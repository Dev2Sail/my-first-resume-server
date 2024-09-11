package studio.hcmc.my_first_resume.module.domain.user

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.id.user.UserSessionId
import studio.hcmc.my_first_resume.module.id.user.UserSignInId
import studio.hcmc.my_first_resume.module.util.Creatable

interface UserSessionDomain<Id, UserSignInId> : Creatable {
    val id: Id
    val userSignInId: UserSignInId?
    override val createdAt: Instant

    interface Verbose<Id, UserSignInId> : UserSessionDomain<Id, UserSignInId> {
        override val id: Id
        override val userSignInId: UserSignInId?
        val userSignIn: UserSignInDomain.Verbose<UserSignInId, *, *>?
        override val createdAt: Instant
    }
}

typealias UserSession = UserSessionDomain<UserSessionId, UserSignInId>
typealias UserSessionVerbose = UserSessionDomain.Verbose<UserSessionId, UserSignInId>