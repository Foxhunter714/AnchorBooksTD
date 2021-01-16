package cl.anchorbooks

import androidx.lifecycle.MutableLiveData
import cl.anchorbooks.remote.RetrofitClient
import timber.log.Timber

class Repository{
    private val bookDatabase = BookApplication.bookDatabase!!
    val books = bookDatabase.bookDao().getBooks()
    val bookDetail: MutableLiveData<BookDetail> = MutableLiveData()

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
    suspend fun getBookDetail(id: Int){
        val response = RetrofitClient.retrofitInstance().getBook(id)
        when(response.isSuccessful){
            true-> response.body()?.let {
                bookDetail.value= it }
            false-> Timber.d("${response.body()}")
        }
    }
}