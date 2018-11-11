package kontroller

import JSON
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import service.getFilmWithId
import service.getFilmWithName
import service.getPagination
import service.getSortFilms

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
                call.respond(statusOk, JSON.getFilms())
            } else {
                call.respond(statusError, CustomError("Wrong request arguments"))
            }
        }


        get<FilmName> { filmName ->
            call.respond(statusOk, getFilmWithName(filmName.name))
        }

        get<FilmId> { filmId ->
            call.respond(statusOk, getFilmWithId(filmId.id))
        }

        get<Pagination> { filmPag ->
            try {
                call.respond(statusOk, getPagination(filmPag, JSON.getFilms()))
            } catch (e: Exception) {
                call.respond(statusError, CustomError("Wrong request arguments"))
            }
        }

        get<Sort> { filmSort ->
            try {
                call.respond(statusOk, getSortFilms(filmSort, JSON.getFilms()))
            } catch (e: Exception) {
                call.respond(statusError, CustomError("Wrong request arguments"))
            }
        }

        get<SortWithPagination> { filmSort ->
            try {
                var films = JSON.getFilms()
                films = getPagination(filmSort.pagination, films)
                films = getSortFilms(filmSort.sort, films)
                call.respond(statusOk, films)
            } catch (e: Exception) {
                call.respond(statusError, CustomError("Wrong request arguments"))
            }
        }

    }
}

