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
import service.*

@Location("/films/{name}")
data class FilmName(val name: String)

@Location("/films/id/{id}")
data class FilmId(val id: Int)

@Location("")
data class Pagination(val offset: Int, val limit: Int)

@Location("/films/sort")
data class Sort(val field: String, val by: String)


val statusOk = HttpStatusCode(200, "Ok")

val statusError = HttpStatusCode(405, "Wrong arguments")

@KtorExperimentalLocationsAPI
fun Route.films() {

    get<FilmName> { filmName ->
        call.respond(statusOk, getFilmWithName(filmName.name))
    }

    get<FilmId> { it ->
        call.respond(statusOk, getFilmWithId(it.id))
    }


    route("/films") {
        get("/") {
            if (call.parameters.isEmpty()) {
                call.respond(statusOk, getAllFilms())
                return@get
            }

            if (!call.parameters["offset"].isNullOrEmpty() && !call.parameters["limit"].isNullOrEmpty()) {
                try {
                    call.respond(statusOk, getPagination(Pagination(call.parameters["offset"]!!.toInt(), call.parameters["limit"]!!.toInt())))
                } catch (e: Exception) {
                    call.respond(statusError, e.message.toString())
                }
                return@get
            } else {
                call.respond(statusError, "Illegal args")
            }
        }
    }

    get<Sort> { it ->
        try {
            call.respond(statusOk, getSortFilms(it))
        } catch (e: Exception) {
            call.respond(statusError, e.message.toString())

        }
    }


}