package cl.anchorbooks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.anchorbooks.databinding.BookItemListBinding
import com.squareup.picasso.Picasso

class BookAdapter: RecyclerView.Adapter<BookAdapter.BookVH>(){
    private var bookList = listOf<Book>()
    private val selectedItem = MutableLiveData<Book>()
    fun selectedItem(): LiveData<Book> = selectedItem

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookVH {
        val binding = BookItemListBinding.inflate(LayoutInflater.from(parent.context))
        return BookVH(binding)
    }

    override fun onBindViewHolder(holder: BookVH, position: Int) {
       val book = bookList[position]
        holder.bind(book)
        holder.itemView.setOnClickListener{
            selectedItem.value = book
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    fun update(pBooksList: List<Book>){
        bookList = pBooksList
        notifyDataSetChanged()
    }
    inner class BookVH(val binding: BookItemListBinding): RecyclerView.ViewHolder(binding.root) {
            fun bind(book: Book){
                binding.authorView.text = book.author
                binding.idView.text = book.id.toString()
                binding.countryView.text = book.country
                binding.titleView.text = book.title
                binding.languageView.text = book.language
                Picasso.get().load(book.imageLink).into(binding.imageView)
            }
    }

}