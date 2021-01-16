package cl.anchorbooks

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BooksDatabaseTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    private lateinit var bookDao: BookDao
    private lateinit var bookDB: BookDatabase
    @Before
    fun setup(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        bookDB= Room.inMemoryDatabaseBuilder(context, BookDatabase::class.java).build()
        bookDao = bookDB.bookDao()
    }
    @After
    fun tearDown(){
        bookDB.close()
    }
    @Test
    fun insertBook() = runBlocking {
        //Given
        val bookList = listOf(BookEntity(1, "Profe Maza", "Chile", "https://grandeprofe.cl", "Chileno", ""))

        //When
        bookDao.insert(bookList)

        //Then
        bookDao.getBooks().observeForever {
            assertThat(it).isNotNull()
            assertThat(it).isNotEmpty()
            assertThat(it).hasSize(1)
        }
    }
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("cl.anchorbooks", appContext.packageName)
    }
}