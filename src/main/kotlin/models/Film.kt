package models

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

class EmptyClass() {}



