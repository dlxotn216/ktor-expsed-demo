package taesu.io.user.routes

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import taesu.io.plugins.long
import taesu.io.user.application.UserRetrieveService
import taesu.io.user.application.UserSaveService
import taesu.io.user.domain.UserSaveCommand

/**
 * Created by taesu on 2024/01/14.
 *
 * @author Lee Tae Su
 * @version ktor-exposed-demo
 * @since ktor-exposed-demo
 */
fun Application.userRouting() {
    routing {
        route("/api/v1/users/{userKey?}") {
            val userRetrieveService: UserRetrieveService by inject()
            get("") {
                call.respond(userRetrieveService.retrieve(call long "userKey"))
            }
        }
        route("/api/v1/users") {
            val userSaveService: UserSaveService by inject()
            post("") {
                val command = this.context.receive(UserSaveCommand::class)
                call.respond(userSaveService.save(command).userKey)
            }
        }
    }
}
