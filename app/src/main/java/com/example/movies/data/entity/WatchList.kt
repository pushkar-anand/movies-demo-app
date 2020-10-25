package com.example.movies.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "watch_lists")
data class WatchList(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "list_id")
    val listID: Long,

    @ColumnInfo(name = "list_name")
    val listName: String,

    @ColumnInfo(name = "created_by")
    var createdBy: Long

)