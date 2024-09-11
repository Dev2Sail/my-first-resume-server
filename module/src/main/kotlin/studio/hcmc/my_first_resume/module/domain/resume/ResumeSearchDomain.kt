package studio.hcmc.my_first_resume.module.domain.resume

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.domain.user.UserDomain
import studio.hcmc.my_first_resume.module.id.resume.ResumeSearchId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.Creatable

interface ResumeSearchDomain<Id, UserId> : Creatable {
    val id: Id
    val userId: UserId
    val body: String
    override val createdAt: Instant

    interface Verbose<Id, UserId> : ResumeSearchDomain<Id, UserId> {
        override val id: Id
        override val userId: UserId
        val user: UserDomain.Verbose<UserId>
        override val createdAt: Instant
    }
}

typealias ResumeSearch = ResumeSearchDomain<ResumeSearchId, UserId>
typealias ResumeSearchVerbose = ResumeSearchDomain.Verbose<ResumeSearchId, UserId>