package taesu.io.user.application

import taesu.io.user.domain.User
import taesu.io.user.domain.UserRepository
import taesu.io.user.domain.UserSaveCommand

/**
 * Created by taesu on 2024/01/22.
 *
 * @author Lee Tae Su
 * @version ktor-exposed-demo
 * @since ktor-exposed-demo
 */
class UserSaveService(
    private val userRepository: UserRepository
) {
    suspend fun save(command: UserSaveCommand): User {
        return userRepository.save(command)
    }
}
