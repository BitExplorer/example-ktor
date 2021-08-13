//@file:Suppress("DEPRECATION", "UNUSED")

package example


import example.config.DatabaseFactory
import example.config.cors
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

//    install(Authentication) {
//        jwt()
//    }
//
//    install(ContentNegotiation) {
//        jackson {
//            enable(SerializationFeature.INDENT_OUTPUT)
//        }
//    }

    //
    DatabaseFactory.init()

    routing {

        get("/") {
            call.respondText("Hello, world!")
        }

        /*install(StatusPages) {
            statusPages()
        }*/
       // api()
    }
}