package com.example.movies.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class MovieWithDescription(

    @Embedded
    val movie: Movie,

    @Relation(
        parentColumn = "movie_id",
        entityColumn = "movie"
    )
    val movieDesc: MovieDesc

)