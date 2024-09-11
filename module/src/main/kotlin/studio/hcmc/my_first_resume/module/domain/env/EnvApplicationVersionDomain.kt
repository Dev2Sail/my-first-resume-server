package studio.hcmc.my_first_resume.module.domain.env

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.user.UserDomain
import studio.hcmc.my_first_resume.module.id.env.EnvApplicationVersionId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.Creatable
import studio.hcmc.my_first_resume.module.util.Modifiable

interface EnvApplicationVersionDomain<Id, UserId> : Creatable, Modifiable {
    val id: Id
    val creatorId: UserId
    val name: String
    val platform: Platform
    val distribution: Distribution
    val expiredAt: Instant?
    override val createdAt: Instant
    override val lastModifiedAt: Instant?

    interface Verbose<Id, UserId> : EnvApplicationVersionDomain<Id, UserId> {
        override val id: Id
        override val creatorId: UserId
        val creator: UserDomain.Verbose<UserId>
        override val name: String
        override val platform: Platform
        override val distribution: Distribution
        override val expiredAt: Instant?
        override val createdAt: Instant
        override val lastModifiedAt: Instant?
    }

    @Serializable
    enum class Platform {
        Admin, Web, Android, Iphoneos
    }

    @Serializable
    enum class Distribution {
        LocalTest, InnerTest, OpenTest, Release
    }
}

typealias EnvApplicationVersion = EnvApplicationVersionDomain<EnvApplicationVersionId, UserId>
typealias EnvApplicationVersionVerbose = EnvApplicationVersionDomain.Verbose<EnvApplicationVersionId, UserId>