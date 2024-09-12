package studio.hcmc.my_first_resume.module.vo.resume

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.resume.ResumeSearch
import studio.hcmc.my_first_resume.module.domain.resume.ResumeSearchVerbose
import studio.hcmc.my_first_resume.module.id.resume.ResumeSearchId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObject
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObject
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
        override val id: ResumeSearchId,
        override val userId: UserId,
        override val user: UserVO.Verbose,
        override val body: String,
        override val createdAt: Instant
    ) : VerboseValueObject, ResumeSearchVerbose
}