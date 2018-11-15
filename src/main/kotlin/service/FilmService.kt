package service

import JSON
import com.mongodb.client.FindIterable
import kontroller.Pagination
import kontroller.Sort
import kontroller.SortWithPagination
import models.Film
import org.litote.kmongo.*


val client = KMongo.createClient()
val db = client.getDatabase("lab11")
val collection = db.getCollection<Film>()


fun getFilmWithName(filmName: String): List<Film> = collection.find(Film::title regex filmName).toList()


fun getAllFilms(): List<Film> = collection.find().toList()

@Throws(Exception::class)
fun getFilmWithId(id: Int): Film = collection.findOne("{_id:$id}") ?: throw NullPointerException()


@Throws(Exception::class)
fun getPagination(pagination: Pagination): FindIterable<Film> =
        if (pagination.limit!! >= 0
                && pagination.offset!! >= 0 && pagination.offset + pagination.limit <= JSON.getFilms().size) {
            collection.find().skip(pagination.offset).limit(pagination.limit)

        } else {
            throw Exception("Illegal arguments")
        }


@Throws(Exception::class)
fun getSortFilms(sort: Sort): FindIterable<Film> = when (sort.field) {

    "id" -> sort(sort.by, "_id")

    "vote_average" -> sort(sort.by, "vote_average")

    "original_language" -> sort(sort.by, "original_language")

    "title" -> sort(sort.by, "title")

    else -> throw Exception("Illegal arguments")
}

fun toListFilm(result: FindIterable<Film>): List<Film> = result.toList()

@Throws(Exception::class)
fun sort(by: String, field: String): FindIterable<Film> = when (by) {

    "up" -> collection.find().sort("{$field:1}")

    "down" -> collection.find().sort("{$field:-1}")

    else -> throw Exception("Illegal arguments")
}

@Throws(Exception::class)
fun getSortWithPagination(sortPag: SortWithPagination): List<Film> {

}





