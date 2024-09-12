package studio.hcmc.my_first_resume.module.dto.resume

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.DataTransferObject

sealed interface ResumeDTO : DataTransferObject {
    @Serializable
    data class Post(
        val companyName: String,
        val body: String,
        val startDate: LocalDateTime,
        val endDate: LocalDateTime,
        val link: String
    ) : ResumeDTO

    @Serializable
    data class Put(
        val companyName: String,
        val body: String,
        val startDate: LocalDateTime,
        val endDate: LocalDateTime,
        val link: String
    ) : ResumeDTO
}