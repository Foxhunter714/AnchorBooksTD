package cl.anchorbooks.remote

import cl.anchorbooks.Book
import cl.anchorbooks.BookDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BookAPI {
    @GET("books")
    suspend fun getBooks(): Response<List<Book>>

    @GET("bookDetail/{}")
    suspend fun getBook(@Path("id") id: Int): Response<BookDetail>
}
