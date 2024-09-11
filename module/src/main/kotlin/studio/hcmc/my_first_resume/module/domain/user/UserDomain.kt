package studio.hcmc.my_first_resume.module.domain.user

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.Creatable
import studio.hcmc.my_first_resume.module.util.Modifiable

interface UserDomain<Id> : Creatable, Modifiable {
    val id: Id
    val email: String
    val password: String
    val passwordSalt: String
    val nickname: String
    override val createdAt: Instant
    override val lastModifiedAt: Instant?

    interface Verbose<Id> : UserDomain<Id> {
        override val id: Id
        override val email: String
        override val password: String
        override val passwordSalt: String
        override val nickname: String
        val metadata: UserMetadataDomain.Verbose<Id>
        override val createdAt: Instant
        override val lastModifiedAt: Instant?
    }
}

typealias User = UserDomain<UserId>
typealias UserVerbose = UserDomain.Verbose<UserId>