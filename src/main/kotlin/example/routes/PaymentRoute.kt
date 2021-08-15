package example.routes

import example.repositories.AccountRepository
import example.repositories.CategoryRepository
import example.repositories.PaymentRepository
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlin.text.get

fun Route.paymentRoute() {

    val paymentRepository = PaymentRepository()

    route("payments") {
        get {
            val payments = paymentRepository.payments()

            call.respondText(payments.toString())
        }
    }
}