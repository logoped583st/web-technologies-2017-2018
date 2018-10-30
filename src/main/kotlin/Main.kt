
import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.*
import io.ktor.jackson.jackson
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Locations
import io.ktor.routing.Routing
import kontroller.films

class Main {

    @KtorExperimentalLocationsAPI
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
        install(Routing) {
            films()
        }
    }

}