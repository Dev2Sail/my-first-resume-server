package studio.hcmc.my_first_resume.module.vo.user

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.user.UserSaltRequest
import studio.hcmc.my_first_resume.module.domain.user.UserSaltRequestVerbose
import studio.hcmc.my_first_resume.module.id.user.UserSaltRequestId
import studio.hcmc.my_first_resume.module.util.ValueObject
import studio.hcmc.my_first_resume.module.util.VerboseValueObject

@Serializable
data class UserSaltRequestVO(
    override val id: UserSaltRequestId,
    override val email: String,
    override val remoteAddress: String,
    override val createdAt: Instant
) : ValueObject, UserSaltRequest {
    @Serializable
    data class Verbose(
        override val id: UserSaltRequestId,
        override val email: String,
        override val remoteAddress: String,
        override val createdAt: Instant
    ) : VerboseValueObject, UserSaltRequestVerbose
}
