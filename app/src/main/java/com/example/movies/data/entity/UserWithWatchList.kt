package com.example.movies.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithWatchList(

    @Embedded
    val user: User,

    @Relation(
        parentColumn = "user_id",
        entityColumn = "created_by"
    )
    val lists: List<WatchList>

)