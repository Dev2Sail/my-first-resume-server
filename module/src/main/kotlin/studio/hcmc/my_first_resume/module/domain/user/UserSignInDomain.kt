package studio.hcmc.my_first_resume.module.domain.user

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.domain.env.EnvApplicationVersionDomain
import studio.hcmc.my_first_resume.module.id.env.EnvApplicationVersionId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.id.user.UserSignInId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Creatable

interface UserSignInDomain<Id, UserId, EnvApplicationVersionId> : Creatable {
    val id: Id
    val userId: UserId
    val remoteAddress: String
    val envApplicationVersionId: EnvApplicationVersionId
    val deviceName: String
    val deviceVersion: String
    override val createdAt: Instant

    interface Verbose<Id, UserId, EnvApplicationVersionId> : UserSignInDomain<Id, UserId, EnvApplicationVersionId> {
        override val id: Id
        override val userId: UserId
        val user: UserDomain.Verbose<UserId>
        override val remoteAddress: String
        override val envApplicationVersionId: EnvApplicationVersionId
        val envApplicationVersion: EnvApplicationVersionDomain.Verbose<EnvApplicationVersionId, UserId>
        override val deviceName: String
        override val deviceVersion: String
        override val createdAt: Instant
    }
}

typealias UserSignIn = UserSignInDomain<UserSignInId, UserId, EnvApplicationVersionId>
typealias UserSignInVerbose = UserSignInDomain.Verbose<UserSignInId, UserId, EnvApplicationVersionId>