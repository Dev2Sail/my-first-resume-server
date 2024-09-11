package studio.hcmc.my_first_resume.module.vo.resume

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.resume.ResumeMetadata
import studio.hcmc.my_first_resume.module.domain.resume.ResumeMetadataVerbose
import studio.hcmc.my_first_resume.module.id.resume.ResumeId
import studio.hcmc.my_first_resume.module.util.ValueObject
import studio.hcmc.my_first_resume.module.util.VerboseValueObject

@Serializable
data class ResumeMetadataVO(
    override val id: ResumeId,
    override val subjectCount: Int,
    override val isFinishCount: Int,
    override val lastModifiedAt: Instant?
) : ValueObject, ResumeMetadata {
    @Serializable
    data class Verbose(
        override val id: ResumeId,
        override val subjectCount: Int,
        override val isFinishCount: Int,
        override val lastModifiedAt: Instant?
    ) : VerboseValueObject, ResumeMetadataVerbose
}
