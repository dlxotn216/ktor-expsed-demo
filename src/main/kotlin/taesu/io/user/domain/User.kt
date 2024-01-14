package taesu.io.user.domain

import io.ktor.server.plugins.*
import java.util.concurrent.ConcurrentHashMap

/**
 * Created by taesu on 2024/01/14.
 *
 * @author Lee Tae Su
 * @version ktor-exposed-demo
 * @since ktor-exposed-demo
 */
class User(
    val userKey: Long,
    val name: String,
    val email: String,
)

interface UserRepository {
    fun findOrThrow(userKey: Long): User
}

class UserRepositoryImpl: UserRepository {
    private val repository: ConcurrentHashMap<Long, User> = ConcurrentHashMap<Long, User>().apply {
        put(1L, User(1L, "taesu", "taesulee93@gmail.com"))
    }
    override fun findOrThrow(userKey: Long): User = repository[userKey] ?: throw NotFoundException("")
}
