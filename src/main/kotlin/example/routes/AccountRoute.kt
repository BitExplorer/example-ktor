package example.routes

import example.repositories.AccountRepository
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlin.text.get

fun Route.accountRoute() {

    val accountRepository = AccountRepository()

    route("accounts") {
        get {
            val accounts = accountRepository.accounts()

            call.respondText(accounts.toString())
        }
    }
}