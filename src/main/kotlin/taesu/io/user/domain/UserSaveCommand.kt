package taesu.io.user.domain

/**
 * Created by taesu on 2024/01/22.
 *
 * @author Lee Tae Su
 * @version ktor-exposed-demo
 * @since ktor-exposed-demo
 */
data class UserSaveCommand(
    val userKey: Long?,
    val name: String,
    val email: String,
)
