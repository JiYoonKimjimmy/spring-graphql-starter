package me.jimmyberg.springgraphqlstarter.book

data class Book(
    private val id: String,
    private val name: String,
    private val pageCount: Int,
    private val authorId: String
) {

    companion object {
        private val books: List<Book> = listOf(
            Book("book-1", "Effective Java", 416, "author-1"),
            Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, "author-2"),
            Book("book-3", "Down Under", 436, "author-3"),
        )

        fun getById(id: String): Book? {
            return books.find { it.id == id }
        }

        fun getByName(name: String): Book? {
            return books.find { compareBookName(it.name, name) }
        }

        fun getByIdAndName(id: String, name: String): Book? {
            return books.find { it.id == id && compareBookName(it.name, name) }
        }

        private fun compareBookName(src: String, tgt: String): Boolean {
            return src.lowercase() == tgt.lowercase()
        }
    }

    fun getAuthorId(): String = this.authorId

}