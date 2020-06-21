package com.example.movies.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.movies.data.entity.convertor.ListToString

@Entity(tableName = "movies")
data class Movie(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "movie_id")
    val movieID: Long,

    @ColumnInfo(name = "movie_name")
    var movieName: String,

    @ColumnInfo(name = "movie_poster")
    var moviePoster: String,

    @TypeConverters(ListToString::class)
    @ColumnInfo(name = "genres")
    var genres: List<String>
)