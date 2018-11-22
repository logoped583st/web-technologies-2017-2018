import kontroller.Sort
import models.Film
import org.junit.Assert
import org.junit.Test
import service.getSortFilms

class ServiceTestSort {

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


    @Test
    fun testSortVoteAverage() {

        Assert.assertEquals(getSortFilms(Sort("vote_average", "up"), JSON.getFilms())[0], Film(
                0,
                508830,
                false,
                0.0F,
                "Kamen Rider Amazons The Movie: The Final Judgement",
                54.048F,
                "/putlftM2cvILAwSmOn6gO0G0C7s.jpg",
                "ja",
                "仮面ライダーアマゾンズ THE MOVIE 最後ノ審判",
                "/p8RXmzb2dvF6P8oDKRAUom1W2ro.jpg",
                false,
                "The “Amazon Livestock Project,” a mysterious care facility, the Amazon extermination organization 4C (Competitive Creatures Control Center) pursuing Haruka Misuzawa . . . all come together in a tale of symbiosis and competition; the mortal combat between the carnivore and herbivore. And, finally, an end to the troubles and conflicts of the Riders, two beings confronting a fierce fate.",
                listOf(
                        28,
                        12,
                        878,
                        27
                ),
                "2018-05-19"
        ))

    }

    @Test
    fun testSortTitle() {

        Assert.assertEquals(getSortFilms(Sort("title", "up"), JSON.getFilms())[0], Film(

                496,
                455656,
                false,
                6.4F,
                "#RealityHigh",
                18.364F,
                "/wUXT3KEh6vjDzwYKiYWwdJNfZOW.jpg",
                "en",
                "#RealityHigh",
                "/q32LUbGLIwws4fH5Kv5E6RFGbmg.jpg",
                false,
                "When nerdy high schooler Dani finally attracts the interest of her longtime crush, she lands in the cross hairs of his ex, a social media celebrity.",
                listOf(
                        35
                ),
                "2017-07-17"
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
}