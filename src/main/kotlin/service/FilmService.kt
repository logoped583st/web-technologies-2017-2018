package service

import JSON
import com.mongodb.client.FindIterable
import kontroller.Pagination
import kontroller.Sort
import kontroller.SortWithPagination
import models.Film
import org.litote.kmongo.*
import kotlin.reflect.KProperty1


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
fun getSortFilms(sort: Sort, films: FindIterable<Film> = collection.find()): FindIterable<Film> = when (sort.field) {

    "id" -> sort(sort.by, Film::id, films)

    "vote_average" -> sort(sort.by, Film::vote_average, films)

    "original_language" -> sort(sort.by, Film::original_language, films)

    "title" -> sort(sort.by, Film::title, films)

    else -> throw Exception("Illegal arguments")
}

fun toListFilm(result: FindIterable<Film>): List<Film> = result.toList()

@Throws(Exception::class)
fun <E : Comparable<E>> sort(by: String, field: KProperty1<Film, E>, films: FindIterable<Film> = collection.find()): FindIterable<Film> = when (by) {

    "up" -> films.ascendingSort(field)

    "down" -> films.descendingSort(field)

    else -> throw Exception("Illegal arguments")
}

@Throws(Exception::class)
fun getSortWithPagination(sortPag: SortWithPagination): List<Film> {
    val partFilms: FindIterable<Film> = getPagination(sortPag.pagination)
    return getSortFilms(sortPag.sort, partFilms).toList()
}





