package example.routes

import example.repositories.CategoryRepository
import example.repositories.DescriptionRepository
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlin.text.get

fun Route.descriptionRoute() {

    val descriptionRepository = DescriptionRepository()

    route("descriptions") {
        get {
            val descriptions = descriptionRepository.descriptions()
            call.respondText(descriptions.toString())
        }
    }
}