package cl.anchorbooks

import retrofit2.Response
import retrofit2.http.GET

interface BookAPI {
    @GET("books")
    suspend fun getBooks(): Response<List<Book>>
}
