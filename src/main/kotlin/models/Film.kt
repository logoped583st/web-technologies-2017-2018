package models

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Table


object Films : Table() {
    val id = integer("id").primaryKey()
    val video = bool("video")
    val vote_average = float("vote_average")
    val title = varchar("title", 255)
    val popularity = float("popularity")
    val poster_path = varchar("poster_path", 255)
    val original_language = varchar("original_language", 255)
    val original_title = varchar("original_title", 255)
    val backdrop_path = varchar("backdrop_path", 255)
    val adult = bool("adult")
    val overview = varchar("overview", 2000)
    val genre_ids = reference("genre_ids", GenreIds)
    val release_date = date("date")
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


object GenreIds : IntIdTable() {
    val genre_ids: List<Int> = ArrayList()
}