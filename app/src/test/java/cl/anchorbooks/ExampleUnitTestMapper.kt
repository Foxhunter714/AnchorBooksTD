package cl.anchorbooks

import org.junit.Test

class ExampleUnitTestMapper {
    @Test
    fun mapperBookApi2DB() {
        //Given
        val book = Book(1, "Profe Maza", "Chilito", "https://grandeprofe.cl", "Chileno", "Mirando la lunita")
        //When
        val response = mapperBookApi2DB(book)
        //Then
        assert(response.id == book.id)
        assert(response.author == book.author)
        assert(response.country == book.country)
        assert(response.imageLink == book.imageLink)
        assert(response.language == book.language)
        assert(response.title == book.title)
    }
}