package example.routes

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
}