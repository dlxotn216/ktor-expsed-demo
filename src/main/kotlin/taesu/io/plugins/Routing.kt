package taesu.io.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import taesu.io.user.routes.userRouting

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
    userRouting()
}


infix fun ApplicationCall.long(paramName: String) =
    parameters[paramName]?.toLong() ?: throw IllegalArgumentException("Cannot resolve parameter [$paramName]")
