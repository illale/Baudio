package com.baudio.data.books

import android.content.Context
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.baudio.model.AudioBook
import com.baudio.model.Author
import org.json.JSONArray
import org.json.JSONObject

class NetworkAudioBookRepository(private val context: Context) : AudioBookRepository {
    override suspend fun getAudioBooks(): List<AudioBook> {
        val queue = Volley.newRequestQueue(context)
        val books = listOf<AudioBook>().toMutableList()
        val url = "https://librivox.org/api/feed/audiobooks?format=json"
        val jsonRequest = JsonObjectRequest(url, { response ->
            val jsonBooks : JSONArray = response.getJSONArray("books")
            for (i in 0..jsonBooks.length()) {
                val book : JSONObject = jsonBooks.getJSONObject(i)
                val authors = listOf<Author>().toMutableList()

                val jsonAuthor = book.getJSONArray("authors")

                for (j in 0..jsonAuthor.length()) {
                    val author = jsonAuthor.getJSONObject(j)
                    authors.add(
                        Author(
                            author.getString("id"),
                            author.getString("first_name"),
                            author.getString("last_name"),
                            author.getString("dob"),
                            author.getString("dod")
                        )
                    )
                }

                val audioBook = AudioBook(
                    book.getString("id"),
                    book.getString("title"),
                    book.getString("description"),
                    book.getString("url_text_source"),
                    book.getString("language"),
                    book.getString("copyright_year"),
                    book.getString("num_sections"),
                    book.getString("url_rss"),
                    book.getString("url_zip_file"),
                    book.getString("url_project"),
                    book.getString("url_librivox"),
                    book.getString("url_other"),
                    book.getString("totaltime"),
                    book.getInt("totaltimesecs"),
                    authors
                )
                books.add(audioBook)
            }
        }, {
            throw IllegalStateException()
        })

        queue.add(jsonRequest)

        return books
    }
}