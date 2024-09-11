package studio.hcmc.my_first_resume.module.domain.certificate

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.domain.user.UserDomain
import studio.hcmc.my_first_resume.module.id.certificate.CertificateId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.Concealable
import studio.hcmc.my_first_resume.module.util.Creatable

interface CertificateDomain<Id, UserId> : Creatable, Concealable {
    val id: Id
    val userId: UserId
    val title: String
    val code: String
    val organization: String
    val acquiredAt: String
    override val createdAt: Instant
    override val concealedAt: Instant?

    interface Verbose<Id, UserId> : CertificateDomain<Id, UserId> {
        override val id: Id
        override val userId: UserId
        val user: UserDomain.Verbose<UserId>
        override val title: String
        override val code: String
        override val organization: String
        override val acquiredAt: String
        override val createdAt: Instant
        override val concealedAt: Instant?
    }
}

typealias Certificate = CertificateDomain<CertificateId, UserId>
typealias CertificateVerbose = CertificateDomain.Verbose<CertificateId, UserId>