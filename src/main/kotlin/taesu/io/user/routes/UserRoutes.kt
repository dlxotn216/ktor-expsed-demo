package taesu.io.user.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import org.koin.ktor.ext.inject
import taesu.io.plugins.long
import taesu.io.user.application.UserRetrieveService

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
    }
}

@Serializable
data class UserRetrieveResponse(
    val userKey: Long,
    val name: String,
    val email: String,
)
