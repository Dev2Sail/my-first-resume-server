package studio.hcmc.my_first_resume.module.domain.resume

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.user.UserDomain
import studio.hcmc.my_first_resume.module.id.resume.ResumeId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.Concealable
import studio.hcmc.my_first_resume.module.util.Creatable
import studio.hcmc.my_first_resume.module.util.Modifiable

interface ResumeDomain<Id, UserId> : Creatable, Modifiable, Concealable {
    val id: Id
    val userId: UserId
    val companyName: String
    val body: String
    val startDate: LocalDateTime
    val endDate: LocalDateTime
    val link: String
    /**
     * 서류 제출 여부
     */
    val isSubmit: Boolean
    /**
     * isSubmit이 true일 때만 status 지정 가능
     */
    val status: Status?
    override val createdAt: Instant
    override val lastModifiedAt: Instant?
    override val concealedAt: Instant?

    interface Verbose<Id, UserId> : ResumeDomain<Id, UserId> {
        override val id: Id
        override val userId: UserId
        val user: UserDomain.Verbose<UserId>
        override val companyName: String
        override val body: String
        override val startDate: LocalDateTime
        override val endDate: LocalDateTime
        override val link: String
        override val isSubmit: Boolean
        override val status: Status?
        val metadata: ResumeMetadataDomain.Verbose<Id>
        override val createdAt: Instant
        override val lastModifiedAt: Instant?
        override val concealedAt: Instant?
    }

    @Serializable
    enum class Status {
        DocumentPass, DocumentFail,
        TestPass, TestFail,
        FirstInterviewPass, FirstInterviewFail,
        SecondInterviewPass, SecondInterviewFail
    }
}

typealias Resume = ResumeDomain<ResumeId, UserId>
typealias ResumeVerbose = ResumeDomain.Verbose<ResumeId, UserId>