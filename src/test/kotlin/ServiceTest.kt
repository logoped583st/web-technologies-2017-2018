import models.Film
import org.junit.Assert
import org.junit.Test
import service.getFilmWithId
import service.getFilmWithName

class ServiceTest {

    @Test
    fun testGetFilmWithId() {
        val id = 460885

        Assert.assertEquals(getFilmWithId(id), Film(142,
                460885,
                false,
                6.5F,
                "Mandy",
                59.256F,
                "/m0yf7J7HsKeK6E81SMRcX8vx6mH.jpg",
                "en",
                "Mandy",
                "/mqbAmIiToU2R4VwZGgCqsfy6Yh4.jpg",
                false,
                "The Shadow Mountains, 1983. Red and Mandy lead a loving and peaceful existence; but when their pine-scented haven is savagely destroyed, Red is catapulted into a phantasmagoric journey filled with bloody vengeance and laced with fire.",
                listOf(
                        28,
                        53,
                        27
                ),
                "2018-09-13"))
    }

    @Test
    fun testGetFilmWithName() {
        val name = "Mandy"
        Assert.assertEquals(getFilmWithName(name), listOf(Film(142,
                460885,
                false,
                6.5F,
                "Mandy",
                59.256F,
                "/m0yf7J7HsKeK6E81SMRcX8vx6mH.jpg",
                "en",
                "Mandy",
                "/mqbAmIiToU2R4VwZGgCqsfy6Yh4.jpg",
                false,
                "The Shadow Mountains, 1983. Red and Mandy lead a loving and peaceful existence; but when their pine-scented haven is savagely destroyed, Red is catapulted into a phantasmagoric journey filled with bloody vengeance and laced with fire.",
                listOf(
                        28,
                        53,
                        27
                ),
                "2018-09-13")))
    }


}