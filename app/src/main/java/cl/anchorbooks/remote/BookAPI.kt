package cl.anchorbooks.remote

import cl.anchorbooks.Book
import retrofit2.Response
import retrofit2.http.GET

interface BookAPI {
    @GET("books")
    suspend fun getBooks(): Response<List<Book>>
}
