package studio.hcmc.my_first_resume.module.dto.resume

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.DataTransferObject

sealed interface ResumeSubjectDTO : DataTransferObject {
    @Serializable
    data class Post(
        val body: String,
        val limitLength: Int,
        val isFinish: Boolean
    ) : ResumeSubjectDTO

    @Serializable
    data class Put(
        val body: String,
        val limitLength: Int,
        val isFinish: Boolean
    ) : ResumeSubjectDTO

    @Serializable
    data class PatchIsFinish(
        val isFinish: Boolean
    ) : ResumeSubjectDTO
}