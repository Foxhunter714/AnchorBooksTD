package cl.anchorbooks

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class BookViewModel: ViewModel(){
    private val repository = Repository()

    private val books = Transformations.map(repository.books){
        entities -> entities.map { mapperBookApi2DB(it) }
    }
    private val selected = MutableLiveData<Book>()

    fun books(): LiveData<List<BookEntity>>? = books
    init {
        viewModelScope.launch {
            repository.getBooks()
        }
    }

    //Detail
    /*fun selected(book: Book){
        selected.value = book

        viewModelScope.launch {
            repository.getBooks()
        }
    }*/
}