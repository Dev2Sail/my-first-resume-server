package studio.hcmc.my_first_resume.module.domain.memo

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.domain.user.UserDomain
import studio.hcmc.my_first_resume.module.id.memo.MemoSearchId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.Creatable

interface MemoSearchDomain<Id, UserId> : Creatable {
    val id: Id
    val userId: UserId
    val body: String
    override val createdAt: Instant

    interface Verbose<Id, UserId> : MemoSearchDomain<Id, UserId> {
        override val id: Id
        override val userId: UserId
        val user: UserDomain.Verbose<UserId>
        override val createdAt: Instant
    }
}

typealias MemoSearch = MemoSearchDomain<MemoSearchId, UserId>
typealias MemoSearchVerbose = MemoSearchDomain.Verbose<MemoSearchId, UserId>