package studio.hcmc.my_first_resume.module.domain.memo

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.domain.user.UserDomain
import studio.hcmc.my_first_resume.module.id.memo.MemoId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Concealable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Creatable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Modifiable

interface MemoDomain<Id, UserId> : Creatable, Modifiable, Concealable {
    val id: Id
    val userId: UserId
    val body: String
    override val createdAt: Instant
    override val lastModifiedAt: Instant?
    override val concealedAt: Instant?

    interface Verbose<Id, UserId> : MemoDomain<Id, UserId> {
        override val id: Id
        override val userId: UserId
        val user: UserDomain.Verbose<UserId>
        override val body: String
        override val createdAt: Instant
        override val lastModifiedAt: Instant?
        override val concealedAt: Instant?
    }
}

typealias Memo = MemoDomain<MemoId, UserId>
typealias MemoVerbose = MemoDomain.Verbose<MemoId, UserId>