package studio.hcmc.my_first_resume.module.vo.resume

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.resume.Resume
import studio.hcmc.my_first_resume.module.domain.resume.ResumeDomain
import studio.hcmc.my_first_resume.module.domain.resume.ResumeVerbose
import studio.hcmc.my_first_resume.module.id.resume.ResumeId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObject
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObject
import studio.hcmc.my_first_resume.module.vo.user.UserVO

@Serializable
data class ResumeVO(
    override val id: ResumeId,
    override val userId: UserId,
    override val companyName: String,
    override val body: String,
    override val startDate: LocalDateTime,
    override val endDate: LocalDateTime,
    override val link: String,
    override val isSubmit: Boolean,
    override val status: ResumeDomain.Status?,
    override val createdAt: Instant,
    override val lastModifiedAt: Instant?,
    override val concealedAt: Instant?
) : ValueObject, Resume {
    @Serializable
    data class Verbose(
        override val id: ResumeId,
        override val userId: UserId,
        override val user: UserVO.Verbose,
        override val companyName: String,
        override val body: String,
        override val startDate: LocalDateTime,
        override val endDate: LocalDateTime,
        override val link: String,
        override val isSubmit: Boolean,
        override val status: ResumeDomain.Status?,
        override val metadata: ResumeMetadataVO.Verbose,
        override val createdAt: Instant,
        override val lastModifiedAt: Instant?,
        override val concealedAt: Instant?
    ) : VerboseValueObject, ResumeVerbose
}
