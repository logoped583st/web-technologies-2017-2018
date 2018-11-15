import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import models.Film

object JSON {

    private val mapper = jacksonObjectMapper()
    private val json: String = this::javaClass::class.java.getResource("films.json").readText()//System.getProperty("user.dir")

    init {
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true)
    }


    fun getFilms(): List<Film> {

        return mapper.readValue(json)
    }
}
