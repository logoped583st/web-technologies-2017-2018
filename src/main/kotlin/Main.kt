import com.fasterxml.jackson.databind.SerializationFeature
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
import service.collection


fun Application.main() {


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

    if (collection.find().toList().isEmpty()) {
        collection.insertMany(JSON.getFilms())
    }
}



