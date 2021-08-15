package example.routes

import example.repositories.AccountRepository
import example.repositories.CategoryRepository
import example.repositories.PaymentRepository
import example.repositories.TransactionRepository
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlin.text.get

fun Route.transactionRoute() {

    val transactionRepository = TransactionRepository()

    route("transactions") {
        get {
            val transactions = transactionRepository.transactions()

            call.respondText(transactions.toString())
        }
    }
}