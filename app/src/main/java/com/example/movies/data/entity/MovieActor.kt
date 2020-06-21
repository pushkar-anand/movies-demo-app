package com.example.movies.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "movie_actor", primaryKeys = ["movie_id", "actor_id"])
data class MovieActor(
    @ColumnInfo(name = "movie_id")
    val movieID: Long,

    @ColumnInfo(name = "actor_id")
    val actorID: Long
)