package com.example.movies.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.movies.data.dao.ActorDao
import com.example.movies.data.dao.MovieActorDao
import com.example.movies.data.dao.MovieDao
import com.example.movies.data.dao.UserWithWatchListDao
import com.example.movies.data.entity.*
import com.example.movies.data.entity.convertor.ListToString
import com.example.movies.util.runInBackground

@Database(
    entities = [
        User::class,
        Movie::class,
        MovieDesc::class,
        Actor::class,
        WatchList::class,
        MovieActor::class
    ], version = 2, exportSchema = false
)
@TypeConverters(ListToString::class)
abstract class MovieDB : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun actorDao(): ActorDao
    abstract fun movieActorDao(): MovieActorDao
    abstract fun userWithWatchList(): UserWithWatchListDao


    companion object {

        @Volatile
        private var movieDB: MovieDB? = null

        fun getInstance(appContext: Context): MovieDB {
            if (movieDB == null) {
                synchronized(MovieDB::class) {
                    if (movieDB == null) {
                        movieDB = Room.databaseBuilder(
                            appContext,
                            MovieDB::class.java,
                            "app.db"
                        ).fallbackToDestructiveMigration()
                            .addCallback(populateDB)
                            .build()
                    }
                }
            }
            return movieDB!!
        }

        private val populateDB = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                val movieID = 1L
                val movie = Movie(
                    movieID,
                    "The Shawshank Redemption",
                    "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX182_CR0,0,182,268_AL__QL50.jpg",
                    listOf("Thriller", "Crime")
                )
                runInBackground {
                    movieDB!!.movieDao().insert(movie)
                }

                val actor1 = Actor(1L, "Morgan Freeman")
                val actor2 = Actor(2L, "Tim Robbins")
                runInBackground {
                    movieDB!!.actorDao().insert(actor1, actor2)
                    movieDB!!.movieActorDao().insert(
                        MovieActor(movieID, 1L),
                        MovieActor(movieID, 2L)
                    )
                }
            }
        }

    }

}