package com.baudio.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AudioBook(
    @PrimaryKey val audioBookId: String,
    val title: String,
    val description: String,
    val textSource: String,
    val language: String,
    val copyrightYear: String,
    val numSections: String,
    val urlRss: String,
    val urlZipFile: String,
    val urlProject: String,
    val urlLibriVox: String,
    val urlOther: String,
    val totalTime: String,
    val totalTimeSecs: Int,
    val author: String
)
