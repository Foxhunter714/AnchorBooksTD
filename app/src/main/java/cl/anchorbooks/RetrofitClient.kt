package cl.anchorbooks

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://my-json-server.typicode.com/Himuravidal/anchorBooks/"
class RetrofitClient{
    companion object {
        fun retrofitInstance(): BookAPI {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()
            ).build()

            return retrofit.create(BookAPI::class.java)
        }
    }
}