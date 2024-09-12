package studio.hcmc.my_first_resume.module.dto.resume

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.DataTransferObject

sealed interface ResumeSubjectAnswerDTO : DataTransferObject {
    @Serializable
    data class Post(
        val body: String
    ) : ResumeSubjectAnswerDTO

    @Serializable
    data class Put(
        val body: String
    ) : ResumeSubjectAnswerDTO
}