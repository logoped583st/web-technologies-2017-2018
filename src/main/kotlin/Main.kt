import com.fasterxml.jackson.databind.SerializationFeature
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.*
import io.ktor.jackson.jackson
import io.ktor.locations.Locations
import io.ktor.response.respond
import io.ktor.routing.Routing
import kontroller.CustomError
import kontroller.films
import kontroller.statusError
import models.Films
import models.GenreIds
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction


fun Application.main() {

    fun initDb() {
        val config = HikariConfig()
        config.driverClassName = "org.h2.Driver"
        config.jdbcUrl = "jdbc:h2:tcp://localhost/~/test"
        config.username = "lab7"
        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.initializationFailTimeout = 1000000000
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()
        val hikariDatabase = HikariDataSource(config)
        Database.connect(hikariDatabase)
    }

    install(Compression)
    install(DefaultHeaders)
    install(CORS) {
        anyHost()
    }
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    install(CallLogging)
    install(Locations)
    install(StatusPages) {
        exception<NumberFormatException> { cause ->
            call.respond(statusError, CustomError(cause.localizedMessage))
        }
    }

    install(Routing) {
        films()
    }
    initDb()

    transaction {
        if (!Films.exists()) {
            SchemaUtils.create(Films, GenreIds)
            Films.batchInsert(JSON.getFilms(), false) { it ->
                this[Films.id] = it.id
                this[Films.video] = it.video
                this[Films.vote_average] = it.vote_average
                this[Films.title] = it.title
                this[Films.popularity] = it.popularity
                this[Films.poster_path] = it.poster_path
                this[Films.original_language] = it.original_language
                this[Films.original_title] = it.original_title
                this[Films.backdrop_path] = it.backdrop_path
                this[Films.adult] = it.adult
                this[Films.overview] = it.overview
                this[Films.vote_count] = it.vote_count
                this[Films.release_date] = it.release_date.toString()

                it.genre_ids.forEach { id ->
                    GenreIds.insert { gen ->
                        gen[filmId] = it.id
                        gen[genre_id] = id
                    }
                }

                this[Films.genre_ids] = it.id
            }

        }
    }
}



