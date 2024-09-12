package studio.hcmc.my_first_resume.module.domain.resume

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.id.resume.ResumeId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Modifiable

interface ResumeMetadataDomain<Id> : Modifiable {
    val id: Id
    val subjectCount: Int
    val isFinishCount: Int
    override val lastModifiedAt: Instant?

    interface Verbose<Id> : ResumeMetadataDomain<Id> {
        override val id: Id
        override val subjectCount: Int
        override val isFinishCount: Int
        override val lastModifiedAt: Instant?
    }
}

typealias ResumeMetadata = ResumeMetadataDomain<ResumeId>
typealias ResumeMetadataVerbose = ResumeMetadataDomain.Verbose<ResumeId>