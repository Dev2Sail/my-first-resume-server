package studio.hcmc.my_first_resume.module.domain.certificate

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import studio.hcmc.my_first_resume.module.domain.user.UserDomain
import studio.hcmc.my_first_resume.module.id.certificate.CertificateId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Concealable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Creatable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Modifiable

interface CertificateDomain<Id, UserId> : Creatable, Modifiable, Concealable {
    val id: Id
    val userId: UserId
    val title: String
    val code: String
    val level: String?
    val organization: String
    val acquireDate: LocalDate
    override val createdAt: Instant
    override val lastModifiedAt: Instant?
    override val concealedAt: Instant?

    interface Verbose<Id, UserId> : CertificateDomain<Id, UserId> {
        override val id: Id
        override val userId: UserId
        val user: UserDomain.Verbose<UserId>
        override val title: String
        override val code: String
        override val level: String?
        override val organization: String
        override val acquireDate: LocalDate
        override val createdAt: Instant
        override val lastModifiedAt: Instant?
        override val concealedAt: Instant?
    }
}

typealias Certificate = CertificateDomain<CertificateId, UserId>
typealias CertificateVerbose = CertificateDomain.Verbose<CertificateId, UserId>