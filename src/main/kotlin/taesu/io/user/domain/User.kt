package taesu.io.user.domain

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * Created by taesu on 2024/01/14.
 *
 * @author Lee Tae Su
 * @version ktor-exposed-demo
 * @since ktor-exposed-demo
 */

object Users: LongIdTable("users", "user_key") {
    val name = varchar("name", 255)
    val email = varchar("email", 255)
}

class User(
    id: EntityID<Long>
): LongEntity(id) {
    val userKey get() = id.value
    val name by Users.name
    val email by Users.email

    companion object: LongEntityClass<User>(Users) {

    }
}

interface UserRepository {
    suspend fun findOrThrow(userKey: Long): User
}

class UserRepositoryImpl: UserRepository {
    override fun findOrThrow(userKey: Long): User = transaction { User[userKey] }
}
