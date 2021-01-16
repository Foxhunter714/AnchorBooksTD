package cl.anchorbooks

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class BookViewModel: ViewModel(){
    private val repository = Repository()
    fun books(): LiveData<List<Book>> = books

    private val books = Transformations.map(repository.books){
        entities -> entities.map {
        mapperBookDB2API(it)}
    }



    init {
        viewModelScope.launch {
            repository.getBooks()
        }
    }

    //Detail
    //private val selected = MutableLiveData<Book>()
    /*fun selected(book: Book){
        selected.value = book

        viewModelScope.launch {
            repository.getBooks()
        }
    }*/
}