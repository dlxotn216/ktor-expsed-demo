package taesu.io.user.application

import taesu.io.user.domain.UserRepository
import taesu.io.user.dtos.UserRetrieveResponse

/**
 * Created by taesu on 2024/01/14.
 *
 * @author Lee Tae Su
 * @version ktor-exposed-demo
 * @since ktor-exposed-demo
 */
class UserRetrieveService(
    private val userRepository: UserRepository
) {
    suspend fun retrieve(userKey: Long): UserRetrieveResponse {
        return userRepository.findOrThrow(userKey).let {
            UserRetrieveResponse(it.userKey, it.name, it.email)
        }
    }
}
