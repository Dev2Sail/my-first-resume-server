package studio.hcmc.my_first_resume.module.dto.user

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.DataTransferObject

sealed interface UserSignInDTO : DataTransferObject {
    @Serializable
    data class Post(
        val email: String,
        val password: String,
        val nextPassword: String,
        val nextPasswordSalt: String,
        val deviceName: String,
        val deviceVersion: String
    ) : UserSignInDTO
}