import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get

fun Route.users() {
    get("/user") {
        print("USER ROUTE")
        call.respondText { JSON.getFilms()[0].toString() }
    }
}