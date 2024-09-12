package studio.hcmc.my_first_resume.module.vo.user

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.user.UserDomain
import studio.hcmc.my_first_resume.module.domain.user.UserSignIn
import studio.hcmc.my_first_resume.module.domain.user.UserSignInVerbose
import studio.hcmc.my_first_resume.module.id.env.EnvApplicationVersionId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.id.user.UserSignInId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObject
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObject
import studio.hcmc.my_first_resume.module.vo.env.EnvApplicationVersionVO

@Serializable
data class UserSIgnInVO(
    override val id: UserSignInId,
    override val userId: UserId,
    override val remoteAddress: String,
    override val envApplicationVersionId: EnvApplicationVersionId,
    override val deviceName: String,
    override val deviceVersion: String,
    override val createdAt: Instant
) : ValueObject, UserSignIn {
    @Serializable
    data class Verbose(
        override val id: UserSignInId,
        override val userId: UserId,
        override val user: UserDomain.Verbose<UserId>,
        override val remoteAddress: String,
        override val envApplicationVersionId: EnvApplicationVersionId,
        override val envApplicationVersion: EnvApplicationVersionVO.Verbose,
        override val deviceName: String,
        override val deviceVersion: String,
        override val createdAt: Instant
    ) : VerboseValueObject, UserSignInVerbose
}
