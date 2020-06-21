package com.example.movies.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movies.data.dao.ActorDao
import com.example.movies.data.dao.MovieDao
import com.example.movies.data.entity.Actor
import com.example.movies.data.entity.Movie

@Database(entities = [Movie::class, Actor::class], version = 1, exportSchema = false)
abstract class MovieDB : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun actorDao(): ActorDao


    companion object {

        @Volatile
        private var movieDB: MovieDB? = null

        fun getInstance(appContext: Context): MovieDB {
            if (movieDB != null) {
                synchronized(MovieDB::class) {
                    if (movieDB != null) {
                        movieDB = Room.databaseBuilder(
                            appContext,
                            MovieDB::class.java,
                            "app.db"
                        ).fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return movieDB!!
        }

    }

}