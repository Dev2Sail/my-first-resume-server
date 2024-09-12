package studio.hcmc.my_first_resume.module.vo.user

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.user.UserSession
import studio.hcmc.my_first_resume.module.domain.user.UserSessionVerbose
import studio.hcmc.my_first_resume.module.id.user.UserSessionId
import studio.hcmc.my_first_resume.module.id.user.UserSignInId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObject
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObject

@Serializable
data class UserSessionVO(
    override val id: UserSessionId,
    override val userSignInId: UserSignInId?,
    override val createdAt: Instant
) : ValueObject, UserSession {
    @Serializable
    data class Verbose(
        override val id: UserSessionId,
        override val userSignInId: UserSignInId?,
        override val userSignIn: UserSIgnInVO.Verbose?,
        override val createdAt: Instant
    ) : VerboseValueObject, UserSessionVerbose
}
