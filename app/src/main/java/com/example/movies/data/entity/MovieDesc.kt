package com.example.movies.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_desc")
data class MovieDesc(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "desc_id")
    val descID: Long,

    @ColumnInfo(name = "movie")
    val movieID: Long,

    @ColumnInfo(name = "description")
    var description: String
)