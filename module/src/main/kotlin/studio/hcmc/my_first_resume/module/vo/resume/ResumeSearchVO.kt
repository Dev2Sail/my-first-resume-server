package studio.hcmc.my_first_resume.module.vo.resume

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.resume.ResumeSearch
import studio.hcmc.my_first_resume.module.domain.resume.ResumeSearchVerbose
import studio.hcmc.my_first_resume.module.id.resume.ResumeSearchId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.ValueObject
import studio.hcmc.my_first_resume.module.util.VerboseValueObject
import studio.hcmc.my_first_resume.module.vo.user.UserVO

@Serializable
data class ResumeSearchVO(
    override val id: ResumeSearchId,
    override val userId: UserId,
    override val body: String,
    override val createdAt: Instant
) : ValueObject, ResumeSearch {
    @Serializable
    data class Verbose(
        override val body: String,
        override val id: ResumeSearchId,
        override val userId: UserId,
        override val user: UserVO.Verbose,
        override val createdAt: Instant
    ) : VerboseValueObject, ResumeSearchVerbose
}