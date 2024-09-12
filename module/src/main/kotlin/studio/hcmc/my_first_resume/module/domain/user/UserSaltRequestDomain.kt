package studio.hcmc.my_first_resume.module.domain.user

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.id.user.UserSaltRequestId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Creatable

interface UserSaltRequestDomain<Id> : Creatable {
    val id: Id
    val email: String
    val remoteAddress: String
    override val createdAt: Instant

    interface Verbose<Id> : UserSaltRequestDomain<Id> {
        override val id: Id
        override val email: String
        override val remoteAddress: String
        override val createdAt: Instant
    }
}

typealias UserSaltRequest = UserSaltRequestDomain<UserSaltRequestId>
typealias UserSaltRequestVerbose = UserSaltRequestDomain.Verbose<UserSaltRequestId>