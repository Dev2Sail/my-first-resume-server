package studio.hcmc.my_first_resume.module.vo.resume

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.resume.ResumeSubject
import studio.hcmc.my_first_resume.module.domain.resume.ResumeSubjectVerbose
import studio.hcmc.my_first_resume.module.id.resume.ResumeId
import studio.hcmc.my_first_resume.module.id.resume.ResumeSubjectId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObject
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObject
import studio.hcmc.my_first_resume.module.vo.user.UserVO

@Serializable
data class ResumeSubjectVO(
    override val id: ResumeSubjectId,
    override val resumeId: ResumeId,
    override val userId: UserId,
    override val body: String,
    override val limitLength: Int,
    override val isFinish: Boolean,
    override val createdAt: Instant,
    override val lastModifiedAt: Instant?,
    override val concealedAt: Instant?
) : ValueObject, ResumeSubject {
    @Serializable
    data class Verbose(
        override val id: ResumeSubjectId,
        override val resumeId: ResumeId,
        override val resume: ResumeVO.Verbose,
        override val userId: UserId,
        override val user: UserVO.Verbose,
        override val body: String,
        override val limitLength: Int,
        override val isFinish: Boolean,
        override val createdAt: Instant,
        override val lastModifiedAt: Instant?,
        override val concealedAt: Instant?
    ) : VerboseValueObject, ResumeSubjectVerbose
}
