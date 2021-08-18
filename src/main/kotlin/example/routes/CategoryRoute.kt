package example.routes

import example.domain.Category
import example.repositories.CategoryRepository
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlin.text.get

fun Route.categoryRoute() {

    val categoryRepository = CategoryRepository()

    route("categories") {
        get {
            val categories = categoryRepository.categories()

            call.respondText(categories.toString())
        }
    }

    route("category/insert") {
        get {
            val category = Category(0, false, "testing123")
            categoryRepository.insertCategory(category)
            call.respondText("completed insert")
        }
    }
}