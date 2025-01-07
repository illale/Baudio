package com.baudio.data.books

import com.baudio.model.AudioBookModel
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class NetworkAudioBookRepository(private val source: AudioBookSource)  {
    private val mutexLock = Mutex()
    private var audioBookModels : List<AudioBookModel> = emptyList()

    suspend fun getAudioBooks(refresh: Boolean = false) {
        if (refresh || audioBookModels.isEmpty()) {
            val books = source.fetchAudioBooks()
            mutexLock.withLock {
                this.audioBookModels = books
            }
        }

        return  mutexLock.withLock { this.audioBookModels }
    }
}