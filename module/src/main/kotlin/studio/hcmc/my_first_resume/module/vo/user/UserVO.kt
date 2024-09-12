package studio.hcmc.my_first_resume.module.vo.user

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.user.User
import studio.hcmc.my_first_resume.module.domain.user.UserMetadataDomain
import studio.hcmc.my_first_resume.module.domain.user.UserVerbose
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObject
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObject

@Serializable
data class UserVO(
    override val id: UserId,
    override val email: String,
    override val password: String,
    override val passwordSalt: String,
    override val nickname: String,
    override val createdAt: Instant,
    override val lastModifiedAt: Instant?
) : ValueObject, User {
    @Serializable
    data class Verbose(
        override val id: UserId,
        override val email: String,
        override val password: String,
        override val passwordSalt: String,
        override val nickname: String,
        override val metadata: UserMetadataDomain.Verbose<UserId>,
        override val createdAt: Instant,
        override val lastModifiedAt: Instant?
    ) : VerboseValueObject, UserVerbose
}
