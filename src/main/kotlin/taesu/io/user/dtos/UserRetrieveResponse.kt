package taesu.io.user.dtos

data class UserRetrieveResponse(
    val userKey: Long,
    val name: String,
    val email: String,
)
