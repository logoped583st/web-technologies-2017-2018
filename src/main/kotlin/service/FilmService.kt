package service

import JSON
import kontroller.Pagination
import kontroller.Sort
import models.Film
import models.Films
import models.toFilm
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Query
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import kotlin.reflect.KProperty0

fun getFilmWithName(filmName: String): List<Film> = transaction {
    return@transaction Films.select {
        (Films.title eq filmName)
    }.map { toFilm(it) }
}

fun getAllFilms(): List<Film> = transaction {
    return@transaction getAllFilmsQuery().map { toFilm(it) }
}

fun getAllFilmsQuery(): Query = transaction {
    return@transaction Films.selectAll()
}

fun getFilmWithId(id: Int): Film =
        transaction {
            return@transaction toFilm(Films.select {
                (Films.id eq id)
            }.first())
        }


@Throws(Exception::class)
fun getPagination(pagination: Pagination, query: Query = getAllFilmsQuery()): Query = transaction {
    if (pagination.limit!! >= 0
            && pagination.offset!! >= 0 && pagination.offset + pagination.limit <= JSON.getFilms().size) {
        return@transaction query.limit(pagination.limit, pagination.offset)

    } else {
        throw Exception("Illegal arguments")
    }
}

fun toListFilm(query: Query): List<Film> =
        transaction {
            return@transaction query.map { toFilm(it) }
        }

@Throws(Exception::class)
fun getSortFilms(sort: Sort, query: Query = getAllFilmsQuery()): List<Film> = when (sort.field) {

    "id" -> sort(sort.by, Films::id, query)

    "vote_average" -> sort(sort.by, Films::vote_average, query)

    "original_language" -> sort(sort.by, Films::original_language, query)

    "title" -> sort(sort.by, Films::title, query)

    else -> throw Exception("Illegal arguments")
}

@Throws(Exception::class)
fun <E : Comparable<E>> sort(by: String, kProperty: KProperty0<Column<E>>, query: Query): List<Film> = transaction {
    when (by) {

        "up" -> query.sortedBy { kProperty.get() }.map { toFilm(it) }

        "down" -> query.sortedBy { kProperty.get() }.map { toFilm(it) }.asReversed()

        else -> throw Exception("Illegal arguments")
    }
}




