package me.jimmyberg.springgraphqlstarter.book

import me.jimmyberg.springgraphqlstarter.author.Author
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class BookController {

    @QueryMapping
    fun bookById(@Argument id: String): Book? {
        return Book.getById(id)
    }

    @QueryMapping
    fun bookByName(@Argument name: String): Book? {
        return Book.getByName(name)
    }

    @QueryMapping
    fun bookByIdAndName(@Argument id: String, @Argument name: String): Book? {
        return Book.getByIdAndName(id, name)
    }

    @SchemaMapping
    fun author(book: Book): Author? {
        return Author.getById(book.getAuthorId())
    }

}