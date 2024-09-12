package studio.hcmc.my_first_resume.module.domain.resume

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.domain.user.UserDomain
import studio.hcmc.my_first_resume.module.id.resume.ResumeId
import studio.hcmc.my_first_resume.module.id.resume.ResumeSubjectId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Concealable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Creatable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Modifiable

interface ResumeSubjectDomain<Id, ResumeId, UserId> : Creatable, Modifiable, Concealable {
    val id: Id
    val resumeId: ResumeId
    val userId: UserId
    val body: String
    val limitLength: Int
    val isFinish: Boolean
    override val createdAt: Instant
    override val lastModifiedAt: Instant?
    override val concealedAt: Instant?

    interface Verbose<Id, ResumeId, UserId> : ResumeSubjectDomain<Id, ResumeId, UserId> {
        override val id: Id
        override val resumeId: ResumeId
        val resume: ResumeDomain.Verbose<ResumeId, UserId>
        override val userId: UserId
        val user: UserDomain.Verbose<UserId>
        override val body: String
        override val limitLength: Int
        override val isFinish: Boolean
        override val createdAt: Instant
        override val lastModifiedAt: Instant?
        override val concealedAt: Instant?
    }
}

typealias ResumeSubject = ResumeSubjectDomain<ResumeSubjectId, ResumeId, UserId>
typealias ResumeSubjectVerbose = ResumeSubjectDomain.Verbose<ResumeSubjectId, ResumeId, UserId>