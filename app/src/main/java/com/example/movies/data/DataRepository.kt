package com.example.movies.data

import android.content.Context
import com.example.movies.data.entity.Actor
import com.example.movies.data.entity.Movie
import com.example.movies.util.runInBackground

class DataRepository private constructor(context: Context) {

    private val movieDB = MovieDB.getInstance(context.applicationContext)
    private val actorDao = movieDB.actorDao()
    private val movieDao = movieDB.movieDao()

    companion object {
        fun getInstance(context: Context): DataRepository {
            return DataRepository(context)
        }
    }

    fun newMovie(movie: Movie) {
        runInBackground {
            movieDao.insert(movie)
        }
    }

    fun newActor(actor: Actor) {
        runInBackground {
            actorDao.insert(actor)
        }
    }

    fun getMovieWithAllActors(movieID: Long) = movieDao.getMovieWithActors(movieID)

}