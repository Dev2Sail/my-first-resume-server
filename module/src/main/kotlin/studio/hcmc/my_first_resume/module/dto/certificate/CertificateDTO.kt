package studio.hcmc.my_first_resume.module.dto.certificate

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.DataTransferObject

sealed interface CertificateDTO : DataTransferObject {
    @Serializable
    data class Post(
        val title: String,
        val code: String,
        val organization: String,
        val acquiredDate: LocalDate
    ) : CertificateDTO

    @Serializable
    data class Put(
        val title: String,
        val code: String,
        val organization: String,
        val acquiredDate: LocalDate
    ) : CertificateDTO
}