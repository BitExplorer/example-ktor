package example

import example.config.DatabaseFactory
import example.config.cors
import example.routes.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*
import org.slf4j.event.Level

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {


    install(DefaultHeaders)
    install(CORS) {
        cors()
    }

    install(CallLogging) {
        level = Level.INFO
    }

    DatabaseFactory.init()

    install(Routing) {
        categoryRoute()
        descriptionRoute()
        accountRoute()
        paymentRoute()
        transactionRoute()
    }

    routing {

        get("/") {
            call.respondText("main")
        }


        /*install(StatusPages) {
            statusPages()
        }*/
       // api()
    }
}