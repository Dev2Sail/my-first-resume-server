package studio.hcmc.my_first_resume.module.dto.user

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.DataTransferObject

sealed interface UserDTO : DataTransferObject {
    @Serializable
    data class Post(
        val email: String,
        val password: String,
        val passwordSalt: String,
        val nickname: String
    ) : UserDTO

    @Serializable
    data class PatchPassword(
        val password: String,
        val passwordSalt: String
    ) : UserDTO

    @Serializable
    data class PatchNickname(
        val nickname: String
    ) : UserDTO
}