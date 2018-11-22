import io.ktor.application.Application
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import org.junit.Assert
import org.junit.Test

class KontrollerTest {

    private val BASE_URL = "localhost:8080/films"
    private val TEST_ID = 143417

    @Test
    fun testAllFilms() = withTestApplication(Application::main) {
        with(handleRequest(HttpMethod.Get, "/films")) {
            Assert.assertEquals(HttpStatusCode.OK, response.status())
            Assert.assertEquals(response.content.isNullOrBlank(), false)
        }

        with(handleRequest(HttpMethod.Get, "/films?qwe")) {
            Assert.assertEquals(HttpStatusCode.MethodNotAllowed, response.status())
            Assert.assertEquals(response.content.isNullOrBlank(), false)
        }
    }
    @Test
    fun testFilmWithId() = withTestApplication(Application::main) {
        with(handleRequest(HttpMethod.Get, "/films/id/$TEST_ID")) {
            Assert.assertEquals(HttpStatusCode.OK, response.status())
            Assert.assertEquals(response.content.isNullOrBlank(), false)
        }
    }

    @Test
    fun testFilmWithName() = withTestApplication(Application::main) {
        with(handleRequest(HttpMethod.Get, "/films/Mandy")) {
            Assert.assertEquals(HttpStatusCode.OK, response.status())
            Assert.assertEquals(response.content.isNullOrBlank(), false)
        }
    }
}