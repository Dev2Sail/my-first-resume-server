package studio.hcmc.my_first_resume.module.domain.resume

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.id.resume.ResumeId
import studio.hcmc.my_first_resume.module.id.resume.ResumeSubjectAnswerId
import studio.hcmc.my_first_resume.module.id.resume.ResumeSubjectId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Concealable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Creatable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Modifiable

interface ResumeSubjectAnswerDomain<Id, ResumeSubjectId, ResumeId> : Creatable, Modifiable, Concealable {
    val id: Id
    val resumeSubjectId: ResumeSubjectId
    val resumeId: ResumeId
    val body: String
    override val createdAt: Instant
    override val lastModifiedAt: Instant?
    override val concealedAt: Instant?

    interface Verbose<Id, ResumeSubjectId, ResumeId> : ResumeSubjectAnswerDomain<Id, ResumeSubjectId, ResumeId> {
        override val id: Id
        override val resumeSubjectId: ResumeSubjectId
        val resumeSubject: ResumeSubjectDomain.Verbose<ResumeSubjectId, ResumeId, *>
        override val resumeId: ResumeId
        val resume: ResumeDomain<ResumeId, *>
        override val body: String
        override val createdAt: Instant
        override val lastModifiedAt: Instant?
        override val concealedAt: Instant?
    }
}

typealias ResumeSubjectAnswer = ResumeSubjectAnswerDomain<ResumeSubjectAnswerId, ResumeSubjectId, ResumeId>
typealias ResumeSubjectAnswerVerbose = ResumeSubjectAnswerDomain.Verbose<ResumeSubjectAnswerId, ResumeSubjectId, ResumeId>