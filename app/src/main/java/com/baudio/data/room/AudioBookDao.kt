package com.baudio.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AudioBookDao {
    @Query("SELECT * FROM audiobook")
    fun getAll(): List<AudioBook>

    @Query("SELECT * FROM audiobook WHERE audioBookId == (:id)")
    fun getById(id: String): AudioBook

    @Insert
    fun insertAll(vararg audioBooks: AudioBook)

    @Delete
    fun delete(audioBook: AudioBook)
}