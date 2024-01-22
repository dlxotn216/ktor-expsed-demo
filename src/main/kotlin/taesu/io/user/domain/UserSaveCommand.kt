package taesu.io.user.domain

/**
 * Created by taesu on 2024/01/22.
 *
 * @author Lee Tae Su
 * @version ktor-exposed-demo
 * @since ktor-exposed-demo
 */
data class UserSaveCommand(
    val userKey: Long?, // TODO Spring Persistable 처럼 userKey가 0 등등일때 신규 생성하게 하는 방법을 찾아보자.
    val name: String,
    val email: String,
)
