package service

import JSON
import kontroller.Pagination
import kontroller.Sort

import models.Film
import kotlin.reflect.KProperty1

fun getFilmWithName(filmName: String) = JSON.getFilms().filter {
    it.title.toLowerCase().contains(filmName.toLowerCase())
}

fun getFilmWithId(id: Int): Film = JSON.getFilms().first {
    it.id == id
}


@Throws(Exception::class)
fun getPagination(pagination: Pagination, films: List<Film>): List<Film> = if (pagination.limit!! >= 0
        && pagination.offset!! >= 0 && pagination.offset + pagination.limit <= JSON.getFilms().size) {
    films.subList(pagination.offset, pagination.offset + pagination.limit)
} else {
    throw Exception("Illegal arguments")
}

@Throws(Exception::class)
fun getSortFilms(sort: Sort, films: List<Film>): List<Film> = when (sort.field) {
    "id" -> sort(sort.by, Film::id, films)

    "vote_average" -> sort(sort.by, Film::vote_average, films)

    "original_language" -> sort(sort.by, Film::original_language, films)

    "title" -> sort(sort.by, Film::title, films)

    else -> throw Exception("eror arguments")
}

@Throws(Exception::class)
fun <E : Comparable<E>> sort(by: String, kProperty1: KProperty1<Film, E>, films: List<Film>): List<Film> = when (by) {

    "up" -> films.sortedBy(kProperty1)

    "down" -> films.sortedBy(kProperty1).asReversed()

    else -> throw Exception("Illegal arguments")
}



