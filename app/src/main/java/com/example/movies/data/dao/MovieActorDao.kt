package com.example.movies.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.movies.data.entity.MovieActor

@Dao
interface MovieActorDao {

    @Insert
    fun insert(vararg movieActor: MovieActor)
}