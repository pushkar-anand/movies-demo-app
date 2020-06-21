package com.example.movies.data.entity.convertor

import androidx.room.TypeConverter

class ListToString {

    companion object {

        @TypeConverter
        @JvmStatic
        fun fromList(list: List<String>): String {
            return list.joinToString()
        }

        @TypeConverter
        @JvmStatic
        fun toList(string: String): List<String> {
            return string.split(",").map { it.trim() }
        }
    }
}