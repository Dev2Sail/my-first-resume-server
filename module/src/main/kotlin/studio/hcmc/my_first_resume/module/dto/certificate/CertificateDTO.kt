package studio.hcmc.my_first_resume.module.dto.certificate

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.DataTransferObject

sealed interface CertificateDTO : DataTransferObject {
    @Serializable
    data class Post(
        val title: String,
        val code: String,
        val organization: String,
        val acquiredAt: String
    ) : CertificateDTO

    @Serializable
    data class Put(
        val title: String,
        val code: String,
        val organization: String,
        val acquiredAt: String
    ) : CertificateDTO
}