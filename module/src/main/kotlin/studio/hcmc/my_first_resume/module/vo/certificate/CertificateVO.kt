package studio.hcmc.my_first_resume.module.vo.certificate

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.certificate.Certificate
import studio.hcmc.my_first_resume.module.domain.certificate.CertificateVerbose
import studio.hcmc.my_first_resume.module.id.certificate.CertificateId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObject
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObject
import studio.hcmc.my_first_resume.module.vo.user.UserVO

@Serializable
data class CertificateVO(
    override val id: CertificateId,
    override val userId: UserId,
    override val title: String,
    override val code: String,
    override val level: String?,
    override val organization: String,
    override val acquireDate: LocalDate,
    override val createdAt: Instant,
    override val lastModifiedAt: Instant?,
    override val concealedAt: Instant?
) : ValueObject, Certificate {
    @Serializable
    data class Verbose(
        override val id: CertificateId,
        override val userId: UserId,
        override val user: UserVO.Verbose,
        override val title: String,
        override val code: String,
        override val level: String?,
        override val organization: String,
        override val acquireDate: LocalDate,
        override val createdAt: Instant,
        override val lastModifiedAt: Instant?,
        override val concealedAt: Instant?
    ) : VerboseValueObject, CertificateVerbose
}
