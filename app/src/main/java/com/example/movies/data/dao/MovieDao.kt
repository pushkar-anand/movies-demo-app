package com.example.movies.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.movies.data.entity.Movie
import com.example.movies.data.entity.MovieWithActors
import com.example.movies.data.entity.MovieWithDescription

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

    @Transaction
    @Query("SELECT * FROM movies WHERE movie_id = :movieID")
    fun getMovieWithDescription(movieID: Long): LiveData<MovieWithDescription>

    @Transaction
    @Query("SELECT * FROM movies WHERE movie_id = :movieID")
    fun getMovieWithActors(movieID: Long): LiveData<MovieWithActors>

}