package com.example.movies.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.movies.data.entity.UserWithWatchList

@Dao
interface UserWithWatchListDao {

    @Transaction
    @Query("SELECT * FROM users WHERE user_id = :userID")
    fun getUserWithWatchList(userID: Long): LiveData<List<UserWithWatchList>>

}