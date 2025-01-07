package com.baudio.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AudioBook::class, Author::class], version = 1, exportSchema = false)
abstract class LibraryDatabase: RoomDatabase() {
    abstract fun audioBookDao(): AudioBookDao
    abstract fun authorDao(): AuthorDao
}