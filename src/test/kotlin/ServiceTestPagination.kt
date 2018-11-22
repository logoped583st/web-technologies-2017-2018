import kontroller.Pagination
import models.Film
import org.junit.Assert
import org.junit.Test
import service.getPagination

class ServiceTestPagination {

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