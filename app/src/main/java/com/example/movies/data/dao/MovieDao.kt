package com.example.movies.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.movies.data.entity.Movie

@Dao
interface MovieDao {

    @Insert
    fun insert(vararg movies: Movie)

    @Update
    fun update(movie: Movie)

    @Query("SELECT * FROM movies WHERE movie_id = :movieID")
    fun getMovie(movieID: Long): LiveData<Movie>

    @Query("SELECT * FROM movies")
    fun getAllMovies(): LiveData<List<Movie>>

}