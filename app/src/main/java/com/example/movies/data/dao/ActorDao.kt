package com.example.movies.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.movies.data.entity.Actor
import com.example.movies.data.entity.ActorWithMovies

@Dao
interface ActorDao {

    @Insert
    fun insert(vararg actors: Actor)

    @Update
    fun update(actor: Actor)

    @Query("SELECT * FROM actors WHERE actor_id = :actorID")
    fun getActor(actorID: Long): LiveData<Actor>

    @Query("SELECT * FROM actors")
    fun getAllActors(): LiveData<List<Actor>>

    @Transaction
    @Query("SELECT * FROM actors WHERE actor_id = :actorID")
    fun getActorMovies(actorID: Long): LiveData<ActorWithMovies>
}