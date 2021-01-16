package cl.anchorbooks

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*
import timber.log.Timber

@Entity(tableName = "book")
data class BookEntity(@PrimaryKey val id: Int, val author: String, val country: String, val imageLink: String, val language: String, val title: String)

@Dao
interface BookDao{
    @Insert
    suspend fun insert(books: List<BookEntity>)

    @Query("SELECT * FROM book")
    fun getBooks(): LiveData<List<BookEntity>>
}
@Database(entities = [BookEntity::class], version = 1)
abstract class BookDatabase: RoomDatabase(){
    abstract fun bookDao(): BookDao
}

class BookApplication: Application(){
    companion object{
        var bookDatabase: BookDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        Timber.d("onCreate de application")
        bookDatabase = Room.databaseBuilder(this, BookDatabase::class.java, "books_database").build()
    }
}