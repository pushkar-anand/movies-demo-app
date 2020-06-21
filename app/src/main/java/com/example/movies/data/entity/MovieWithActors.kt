package com.example.movies.data.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class MovieWithActors(

    @Embedded
    val movie: Movie,

    @Relation(
        parentColumn = "movie_id",
        entityColumn = "actor_id",
        associateBy = Junction(MovieActor::class)
    )
    val actors: List<Actor>

)