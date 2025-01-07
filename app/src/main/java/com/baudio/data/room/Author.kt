package com.baudio.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Author(
    @PrimaryKey val authorId: String,
    val firstName: String,
    val lastName: String,
    val dob: String,
    val dod: String
)
