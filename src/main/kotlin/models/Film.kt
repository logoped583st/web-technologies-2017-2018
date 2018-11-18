package models

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction


object Films : Table() {
    val id = integer("id").uniqueIndex().primaryKey()
    val video = bool("video")
    val vote_average = float("vote_average")
    val title = varchar("title", 255)
    val popularity = float("popularity")
    val vote_count = integer("vote_count")
    val poster_path = varchar("poster_path", 255).nullable()
    val original_language = varchar("original_language", 255)
    val original_title = varchar("original_title", 255)
    val backdrop_path = varchar("backdrop_path", 255).nullable()
    val adult = bool("adult")
    val overview = varchar("overview", 2000).nullable()
//    val genre_ids: Column<Int> = reference("filmId", id)
    val genre_ids = (integer("filmId") references GenreIds.filmId)
    val release_date = varchar("date", 255)
}

data class Film(val vote_count: Int,
                val id: Int,
                val video: Boolean,
                val vote_average: Float,
                val title: String,
                val popularity: Float,
                val poster_path: String?,
                val original_language: String,
                val original_title: String,
                val backdrop_path: String?,
                val adult: Boolean,
                val overview: String?,
                val genre_ids: List<Int>,
                val release_date: String?)


object GenreIds : Table() {
    val filmId = integer("filmId")
    val genre_id = integer("genre_id").nullable()
}

fun toGenreIds(id: Int): List<Int> = transaction {
    val list: ArrayList<Int> = ArrayList()
    (Films innerJoin GenreIds).selectAll().map {
        println(it[GenreIds.genre_id].toString())
        list.add(it[GenreIds.genre_id]!!)
    }
    return@transaction list
}


fun toFilm(row: ResultRow): Film = Film(vote_count = row[Films.vote_count],
        id = row[Films.id],
        video = row[Films.video],
        vote_average = row[Films.vote_average],
        title = row[Films.title],
        popularity = row[Films.popularity],
        poster_path = row[Films.poster_path],
        original_language = row[Films.original_language],
        original_title = row[Films.original_title],
        backdrop_path = row[Films.backdrop_path],
        adult = row[Films.adult],
        overview = row[Films.overview],
        release_date = row[Films.release_date],
        genre_ids = (toGenreIds(row[Films.genre_ids]))
)

