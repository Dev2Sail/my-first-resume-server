package studio.hcmc.my_first_resume.module.dto.resume

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.DataTransferObject

sealed interface ResumeSearchDTO : DataTransferObject {
    @Serializable
    data class Post(
        val body: String
    ) : ResumeSearchDTO
}