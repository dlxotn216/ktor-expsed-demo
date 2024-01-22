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
    var name by Users.name
    var email by Users.email

    companion object: LongEntityClass<User>(Users) {

    }
}

interface UserRepository {
    suspend fun findOrThrow(userKey: Long): User
    suspend fun save(command: UserSaveCommand): User
}

class UserRepositoryImpl: UserRepository {
    override suspend fun findOrThrow(userKey: Long): User = transaction { User[userKey] }
    override suspend fun save(command: UserSaveCommand): User = transaction {
        User.new(command.userKey) {
            this.name = command.name
            this.email = command.email
        }
    }
}
