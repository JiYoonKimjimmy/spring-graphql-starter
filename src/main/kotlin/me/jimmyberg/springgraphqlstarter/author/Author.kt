package me.jimmyberg.springgraphqlstarter.author

data class Author(
    private val id: String,
    private val firstName: String,
    private val lastName: String
) {

    companion object {
        private val authors: List<Author> = listOf(
            Author("author-1", "Joshua", "Bloch"),
            Author("author-2", "Douglas", "Adams"),
            Author("author-3", "Bill", "Bryson")
        )

        fun getById(id: String): Author? {
            return authors.find { it.id == id }
        }
    }
}