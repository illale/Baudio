package com.baudio.data.books

import com.baudio.model.AudioBook

interface AudioBookRepository {
    suspend fun getAudioBooks(): List<AudioBook>
}