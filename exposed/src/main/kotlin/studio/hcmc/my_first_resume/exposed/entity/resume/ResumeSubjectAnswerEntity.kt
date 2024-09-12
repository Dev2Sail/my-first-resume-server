package studio.hcmc.my_first_resume.exposed.entity.resume

import kotlinx.datetime.Instant
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import studio.hcmc.my_first_resume.exposed.repository.resume.ResumeRepository
import studio.hcmc.my_first_resume.exposed.repository.resume.ResumeSubjectRepository
import studio.hcmc.my_first_resume.exposed.table.resume.ResumeSubjectAnswerTable
import studio.hcmc.my_first_resume.module.domain.resume.ResumeSubjectAnswerDomain
import studio.hcmc.my_first_resume.module.dto.resume.ResumeSubjectAnswerDTO
import studio.hcmc.my_first_resume.module.id.resume.ResumeId
import studio.hcmc.my_first_resume.module.id.resume.ResumeSubjectAnswerId
import studio.hcmc.my_first_resume.module.id.resume.ResumeSubjectId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObjectConverter
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObjectConverter
import studio.hcmc.my_first_resume.module.vo.resume.ResumeSubjectAnswerVO

class ResumeSubjectAnswerEntity(id: EntityID<Long>) :
    LongEntity(id),
    ResumeSubjectAnswerDomain.Verbose<EntityID<Long>, EntityID<Long>, EntityID<Long>>,
    ValueObjectConverter<ResumeSubjectAnswerVO>,
    VerboseValueObjectConverter<ResumeSubjectAnswerVO.Verbose>
{
    override var resumeSubjectId by ResumeSubjectAnswerTable.resumeSubjectId
    override val resumeSubject by ResumeSubjectRepository referencedOn ResumeSubjectAnswerTable.resumeSubjectId
    override var resumeId by ResumeSubjectAnswerTable.resumeId
    override val resume by ResumeRepository referencedOn ResumeSubjectAnswerTable.resumeId
    override var body by ResumeSubjectAnswerTable.body
    override var createdAt by ResumeSubjectAnswerTable.createdAt
    override var lastModifiedAt by ResumeSubjectAnswerTable.lastModifiedAt
    override var concealedAt by ResumeSubjectAnswerTable.concealedAt

    override fun toValueObject() = ResumeSubjectAnswerVO(
        id = ResumeSubjectAnswerId(id.value),
        resumeSubjectId = ResumeSubjectId(resumeSubjectId.value),
        resumeId = ResumeId(resumeId.value),
        body = body,
        createdAt = createdAt,
        lastModifiedAt = lastModifiedAt,
        concealedAt = concealedAt
    )

    override fun toVerboseValueObject() = ResumeSubjectAnswerVO.Verbose(
        id = ResumeSubjectAnswerId(id.value),
        resumeSubjectId = ResumeSubjectId(resumeSubjectId.value),
        resumeSubject = resumeSubject.toVerboseValueObject(),
        resumeId = ResumeId(resumeId.value),
        resume = resume.toVerboseValueObject(),
        body = body,
        createdAt = createdAt,
        lastModifiedAt = lastModifiedAt,
        concealedAt = concealedAt
    )

    fun fromDataTransferObject(dto: ResumeSubjectAnswerDTO, now: Instant) {
        when(dto) {
            is ResumeSubjectAnswerDTO.Post -> fromDataTransferObject(dto, now)
            is ResumeSubjectAnswerDTO.Put -> fromDataTransferObject(dto, now)
        }
    }

    private fun fromDataTransferObject(dto: ResumeSubjectAnswerDTO.Post, now: Instant) {
        this.body = dto.body
        this.createdAt = now
    }

    private fun fromDataTransferObject(dto: ResumeSubjectAnswerDTO.Put, now: Instant) {
        this.body = dto.body
        this.lastModifiedAt = now

    }
}