package com.baudio.data.books

import com.baudio.model.AudioBookModel

interface AudioBookSource {
    suspend fun fetchAudioBooks(): List<AudioBookModel>
}