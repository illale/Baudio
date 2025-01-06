package com.baudio.model

data class AudioBook(
    val id: String,
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
    val authors: List<Author>
)
