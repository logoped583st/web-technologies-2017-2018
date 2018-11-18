package kontroller

import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import org.jetbrains.exposed.sql.Query
import service.*

@KtorExperimentalLocationsAPI
@Location("/{name}")
data class FilmName(val name: String)

@KtorExperimentalLocationsAPI
@Location("/id/{id}")
data class FilmId(val id: Int)


@KtorExperimentalLocationsAPI
@Location("/")
data class Pagination(val offset: Int?, val limit: Int?)

@KtorExperimentalLocationsAPI
@Location("/")
data class Sort(val field: String, val by: String)

data class CustomError(val error: String)

@Location("/")
data class SortWithPagination(val pagination: Pagination, val sort: Sort)


val statusOk = HttpStatusCode(200, "Ok")

val statusError = HttpStatusCode(405, "Wrong arguments")

@KtorExperimentalLocationsAPI
fun Route.films() {
    route("/films") {
        get("{...}") {
            if (call.parameters.isEmpty()) {
                call.respond(HttpStatusCode.OK, getAllFilms())
            } else {
                call.respond(HttpStatusCode.MethodNotAllowed, CustomError("Wrong request arguments"))
            }
        }


        get<FilmName> { filmName ->
            call.respond(HttpStatusCode.OK, getFilmWithName(filmName.name))
        }

        get<FilmId> { filmId ->
            call.respond(HttpStatusCode.OK, getFilmWithId(filmId.id))
        }

        get<Pagination> { filmPag ->
            try {
                call.respond(statusOk, toListFilm(getPagination(filmPag)))
            } catch (e: Exception) {
                call.respond(HttpStatusCode.MethodNotAllowed, CustomError("Wrong request arguments"))
            }
        }

        get<Sort> { filmSort ->
            try {
                call.respond(statusOk, getSortFilms(filmSort))
            } catch (e: Exception) {
                call.respond(HttpStatusCode.MethodNotAllowed, CustomError("Wrong request arguments"))
            }
        }

        get<SortWithPagination> { filmSort ->
            try {
                val query: Query = getPagination(filmSort.pagination)
                call.respond(HttpStatusCode.OK, getSortFilms(filmSort.sort, query))
            } catch (e: Exception) {
                call.respond(HttpStatusCode.MethodNotAllowed, CustomError("Wrong request arguments"))
            }
        }

    }
}

