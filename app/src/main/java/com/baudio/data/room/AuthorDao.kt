package com.baudio.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AuthorDao {
    @Query("SELECT * FROM author")
    fun getAll(): List<Author>

    @Query("SELECT * FROM author WHERE authorId == (:id)")
    fun getById(id: String): Author

    @Insert
    fun insertAll(vararg authors: Author)

    @Delete
    fun delete(author: Author)
}