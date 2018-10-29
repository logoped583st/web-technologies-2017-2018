package service

import JSON
import kontroller.Pagination
import kontroller.Sort
import models.Film

fun getFilmWithName(filmName: String) = JSON.getFilms().filter {
    it.title.toLowerCase().contains(filmName.toLowerCase())
}

fun getFilmWithId(id: Int): Film = JSON.getFilms().first {
    it.id == id
}

fun getAllFilms() = JSON.getFilms()

@Throws(Exception::class)
fun getPagination(pagination: Pagination): List<Film> = if (pagination.limit >= 0 && pagination.offset >= 0 && pagination.offset + pagination.limit <= JSON.getFilms().size) {
    JSON.getFilms().subList(pagination.offset, pagination.offset + pagination.limit)
} else {
    throw Exception("Illegl arhuments")
}

@Throws(Exception::class)
fun getSortFilms(sort: Sort): List<Film> = when (sort.field) {
    "id" -> sortId(sort.by)

    "vote_average" -> sortVoteAverage(sort.by)

    "original_langiage" -> originalLanguage(sort.by)

    "title" -> sortTitle(sort.by)

    else ->  throw Exception("eror arguments")
}



fun sortId(by: String): List<Film> = if (by == "up") {
    JSON.getFilms().sortedWith(compareBy { it.id })
} else {
    JSON.getFilms().sortedWith(compareBy { it.id }).reversed()
}

fun sortVoteAverage(by: String): List<Film> = if (by == "up") {
    JSON.getFilms().sortedWith(compareBy { it.vote_average })
} else {
    JSON.getFilms().sortedWith(compareBy { it.vote_average }).reversed()
}


fun sortTitle(by: String): List<Film> =
        if (by == "up") {
            JSON.getFilms().sortedWith(compareBy { it.title })
        } else {
            JSON.getFilms().sortedWith(compareBy { it.title }).reversed()
        }

fun originalLanguage(by: String): List<Film> =
        if (by == "up") {
            JSON.getFilms().sortedWith(compareBy { it.original_language })
        } else {
            JSON.getFilms().sortedWith(compareBy { it.original_language }).reversed()
        }


