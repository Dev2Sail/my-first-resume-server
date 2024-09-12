package studio.hcmc.my_first_resume.exposed.entity.resume

import kotlinx.datetime.Instant
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import studio.hcmc.my_first_resume.exposed.repository.resume.ResumeRepository
import studio.hcmc.my_first_resume.exposed.repository.user.UserRepository
import studio.hcmc.my_first_resume.exposed.table.resume.ResumeSubjectTable
import studio.hcmc.my_first_resume.module.domain.resume.ResumeSubjectDomain
import studio.hcmc.my_first_resume.module.dto.resume.ResumeSubjectDTO
import studio.hcmc.my_first_resume.module.id.resume.ResumeId
import studio.hcmc.my_first_resume.module.id.resume.ResumeSubjectId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObjectConverter
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObjectConverter
import studio.hcmc.my_first_resume.module.vo.resume.ResumeSubjectVO

class ResumeSubjectEntity(id: EntityID<Long>) :
    LongEntity(id),
    ResumeSubjectDomain.Verbose<EntityID<Long>, EntityID<Long>, EntityID<Long>>,
    ValueObjectConverter<ResumeSubjectVO>,
    VerboseValueObjectConverter<ResumeSubjectVO.Verbose>
{
    override var resumeId by ResumeSubjectTable.resumeId
    override val resume by ResumeRepository referencedOn ResumeSubjectTable.resumeId
    override var userId by ResumeSubjectTable.userId
    override val user by UserRepository referencedOn ResumeSubjectTable.userId
    override var body by ResumeSubjectTable.body
    override var limitLength by ResumeSubjectTable.limitLength
    override var isFinish by ResumeSubjectTable.isFinish
    override var createdAt by ResumeSubjectTable.createdAt
    override var lastModifiedAt by ResumeSubjectTable.lastModifiedAt
    override var concealedAt by ResumeSubjectTable.concealedAt

    override fun toValueObject() = ResumeSubjectVO(
        id = ResumeSubjectId(id.value),
        resumeId = ResumeId(resumeId.value),
        userId = UserId(userId.value),
        body = body,
        limitLength = limitLength,
        isFinish = isFinish,
        createdAt = createdAt,
        lastModifiedAt = lastModifiedAt,
        concealedAt = concealedAt
    )

    override fun toVerboseValueObject() = ResumeSubjectVO.Verbose(
        id = ResumeSubjectId(id.value),
        resumeId = ResumeId(resumeId.value),
        resume = resume.toVerboseValueObject(),
        userId = UserId(userId.value),
        user = user.toVerboseValueObject(),
        body = body,
        limitLength = limitLength,
        isFinish = isFinish,
        createdAt = createdAt,
        lastModifiedAt = lastModifiedAt,
        concealedAt = concealedAt
    )

    fun fromDataTransferObject(dto: ResumeSubjectDTO, now: Instant) {
        when(dto) {
            is ResumeSubjectDTO.Post -> fromDataTransferObject(dto, now)
            is ResumeSubjectDTO.Put -> fromDataTransferObject(dto, now)
            is ResumeSubjectDTO.PatchIsFinish -> fromDataTransferObject(dto, now)
        }
    }

    private fun fromDataTransferObject(dto: ResumeSubjectDTO.Post, now: Instant) {
        this.body = dto.body
        this.limitLength = dto.limitLength
        this.isFinish = false
        this.createdAt = now
    }

    private fun fromDataTransferObject(dto: ResumeSubjectDTO.Put, now: Instant) {
        this.body = dto.body
        this.limitLength = dto.limitLength
        this.isFinish = dto.isFinish
        this.lastModifiedAt = now
    }

    private fun fromDataTransferObject(dto: ResumeSubjectDTO.PatchIsFinish, now: Instant) {
        this.isFinish = dto.isFinish
        this.lastModifiedAt = now
    }
}