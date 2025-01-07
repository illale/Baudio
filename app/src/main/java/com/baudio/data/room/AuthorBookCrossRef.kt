package com.baudio.data.room

import androidx.room.Entity

@Entity(primaryKeys = ["bookId", "authorId"])
data class AuthorBookCrossRef(
    val audioBookId: String,
    val authorId: String
)