package studio.hcmc.my_first_resume.module.domain.user

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.Modifiable

interface UserMetadataDomain<Id> : Modifiable {
    val id: Id
    val resumeCount: Int
    val portfolioCount: Int
    val memoCount: Int
    val articleCount: Int
    val commentCount: Int
    override val lastModifiedAt: Instant?

    interface Verbose<Id> : UserMetadataDomain<Id> {
        override val id: Id
        override val resumeCount: Int
        override val portfolioCount: Int
        override val memoCount: Int
        override val articleCount: Int
        override val commentCount: Int
        override val lastModifiedAt: Instant?
    }
}

typealias UserMetadata = UserMetadataDomain<UserId>
typealias UserMetadataVerbose = UserMetadataDomain.Verbose<UserId>