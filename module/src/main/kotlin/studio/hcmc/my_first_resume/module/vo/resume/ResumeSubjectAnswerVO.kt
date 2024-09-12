package studio.hcmc.my_first_resume.module.vo.resume

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.resume.ResumeSubjectAnswer
import studio.hcmc.my_first_resume.module.domain.resume.ResumeSubjectAnswerVerbose
import studio.hcmc.my_first_resume.module.id.resume.ResumeId
import studio.hcmc.my_first_resume.module.id.resume.ResumeSubjectAnswerId
import studio.hcmc.my_first_resume.module.id.resume.ResumeSubjectId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObject
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObject

@Serializable
data class ResumeSubjectAnswerVO(
    override val id: ResumeSubjectAnswerId,
    override val resumeSubjectId: ResumeSubjectId,
    override val resumeId: ResumeId,
    override val body: String,
    override val createdAt: Instant,
    override val lastModifiedAt: Instant?,
    override val concealedAt: Instant?
) : ValueObject, ResumeSubjectAnswer {
    @Serializable
    data class Verbose(
        override val id: ResumeSubjectAnswerId,
        override val resumeSubjectId: ResumeSubjectId,
        override val resumeSubject: ResumeSubjectVO.Verbose,
        override val resumeId: ResumeId,
        override val resume: ResumeVO.Verbose,
        override val body: String,
        override val createdAt: Instant,
        override val lastModifiedAt: Instant?,
        override val concealedAt: Instant?
    ) : VerboseValueObject, ResumeSubjectAnswerVerbose
}
