import kontroller.Pagination
import kontroller.Sort
import models.Film
import org.junit.Assert
import org.junit.Test
import service.getFilmWithId
import service.getFilmWithName
import service.getPagination
import service.getSortFilms

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

    @Test
    fun testSortId() {
        Assert.assertEquals(getSortFilms(Sort("id", "up"), JSON.getFilms())[0], Film(
                9834,
                11,
                false,
                8.2F,
                "Star Wars",
                31.629F,
                "/btTdmkgIvOi0FFip1sPuZI2oQG6.jpg",
                "en",
                "Star Wars",
                "/4iJfYYoQzZcONB9hNzg0J0wWyPH.jpg",
                false,
                "Princess Leia is captured and held hostage by the evil Imperial forces in their effort to take over the galactic Empire. Venturesome Luke Skywalker and dashing captain Han Solo team together with the loveable robot duo R2-D2 and C-3PO to rescue the beautiful princess and restore peace and justice in the Empire.",
                listOf(
                        12,
                        28,
                        878
                ),
                "1977-05-25"
        ))

        Assert.assertEquals(getSortFilms(Sort("id", "down"), JSON.getFilms())[0], Film(
                0,
                551629,
                false,
                0F,
                "Asih",
                9.526F,
                "/7nLltUcTH5IicANMrCsWAxCsT5n.jpg",
                "id",
                "Asih",
                null,
                false,
                "Asih gone mad after she killed her own baby and commited suicide. Not far from there, there's this happy couple who just had a baby. But Asih is ready to terrorize them.",
                listOf(
                        27,
                        18
                ),
                "2018-10-11"
        ))

    }

    @Test(expected = java.lang.Exception::class)
    fun testWrongSort() {
        getSortFilms(Sort("fasd", "down"), JSON.getFilms())
        getSortFilms(Sort("id", "fasd"), JSON.getFilms())
    }

    @Test(expected = java.lang.Exception::class)
    fun testWrongSortBy() {
        getSortFilms(Sort("id", "fasd"), JSON.getFilms())
    }


    @Test
    fun testPagination() {
        val pagFilms = getPagination(Pagination(10, 10), JSON.getFilms())
        Assert.assertEquals(pagFilms[0], Film(1,
                143417,
                false,
                2F,
                "Blue Film: Estimation",
                54.367F,
                "/4B8GnbdCklT2hkDzvMPoRjfbYNt.jpg",
                "ja",
                "蒼いフィルム　品さだめ",
                null,
                false,
                "The film depicts the plight of a female office worker whose boss introduces to the world of pornographic films.",
                ArrayList<Int>(),
                "1968-03-01"
        ))
        Assert.assertEquals(pagFilms.size, 10)
    }

    @Test(expected = java.lang.Exception::class)
    fun testWrongPagination() {
        getPagination(Pagination(10, -123), JSON.getFilms())
    }
}