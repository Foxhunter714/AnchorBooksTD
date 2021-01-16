package cl.anchorbooks

import cl.anchorbooks.remote.RetrofitClient
import timber.log.Timber

class Repository{
    private val bookDatabase = BookApplication.bookDatabase!!
    val books = bookDatabase.bookDao().getBooks()

    suspend fun getBooks(){
        val response = RetrofitClient.retrofitInstance().getBooks()
        if (response.isSuccessful){
            response.body()?.let {list ->
                val res = list.map {
                    mapperBookApi2DB(it) }
                bookDatabase.bookDao().insert(res)
            }
        } else {
            Timber.d("${response.errorBody()}")
        }
    }
}