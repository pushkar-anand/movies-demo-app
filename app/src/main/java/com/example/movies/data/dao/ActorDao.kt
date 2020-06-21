package com.example.movies.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.movies.data.entity.Actor

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
}