package cl.anchorbooks

fun mapperBookApi2DB(book: Book): BookEntity{
    return BookEntity(book.id, book.author, book.country, book.imageLink, book.language, book.title)
}

fun mapperBookDB2API(entity: BookEntity): Book{
    return Book(entity.id, entity.author, entity.country,entity.imageLink, entity.language, entity.title)
}