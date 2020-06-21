package com.example.movies.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "actors")
data class Actor(

    @PrimaryKey
    @ColumnInfo(name = "actor_id")
    val actorID: Long,

    @ColumnInfo(name = "actor_name")
    var actorName: String
)