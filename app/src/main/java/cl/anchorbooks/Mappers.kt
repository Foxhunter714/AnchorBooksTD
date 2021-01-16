package cl.anchorbooks

fun mapperBookApi2DB(book: Book): BookEntity{
    return BookEntity(book.id, book.author, book.country, book.imageLink, book.language, book.title)
}