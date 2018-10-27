import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.*
import io.ktor.jackson.jackson
import io.ktor.routing.Routing

class Main {

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
        install(Routing) {
            users()
        }
    }
}
