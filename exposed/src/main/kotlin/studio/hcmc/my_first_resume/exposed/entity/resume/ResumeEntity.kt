package studio.hcmc.my_first_resume.exposed.entity.resume

import kotlinx.datetime.Instant
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import studio.hcmc.my_first_resume.exposed.repository.resume.ResumeMetadataRepository
import studio.hcmc.my_first_resume.exposed.repository.user.UserRepository
import studio.hcmc.my_first_resume.exposed.repository.user.UserSignInRepository.backReferencedOn
import studio.hcmc.my_first_resume.exposed.table.resume.ResumeTable
import studio.hcmc.my_first_resume.module.domain.resume.ResumeDomain
import studio.hcmc.my_first_resume.module.dto.resume.ResumeDTO
import studio.hcmc.my_first_resume.module.id.resume.ResumeId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObjectConverter
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObjectConverter
import studio.hcmc.my_first_resume.module.vo.resume.ResumeVO

class ResumeEntity(id: EntityID<Long>) :
    LongEntity(id),
    ResumeDomain.Verbose<EntityID<Long>, EntityID<Long>>,
    ValueObjectConverter<ResumeVO>,
    VerboseValueObjectConverter<ResumeVO.Verbose>
{
    override var userId by ResumeTable.userId
    override val user by UserRepository referencedOn ResumeTable.userId
    override var companyName by ResumeTable.companyName
    override var body by ResumeTable.body
    override var startDate by ResumeTable.startDate
    override var endDate by ResumeTable.endDate
    override var link by ResumeTable.link
    override var isSubmit by ResumeTable.isSubmit
    override var status by ResumeTable.status
    override val metadata by ResumeMetadataRepository backReferencedOn ResumeTable.id
    override var createdAt by ResumeTable.createdAt
    override var lastModifiedAt by ResumeTable.lastModifiedAt
    override var concealedAt by ResumeTable.concealedAt

    override fun toValueObject() = ResumeVO(
        id = ResumeId(id.value),
        userId = UserId(userId.value),
        companyName = companyName,
        body = body,
        startDate = startDate,
        endDate = endDate,
        link = link,
        isSubmit = isSubmit,
        status = status,
        createdAt = createdAt,
        lastModifiedAt = lastModifiedAt,
        concealedAt = concealedAt
    )

    override fun toVerboseValueObject() = ResumeVO.Verbose(
        id = ResumeId(id.value),
        userId = UserId(userId.value),
        user = user.toVerboseValueObject(),
        companyName = companyName,
        body = body,
        startDate = startDate,
        endDate = endDate,
        link = link,
        isSubmit = isSubmit,
        status = status,
        metadata = metadata.toVerboseValueObject(),
        createdAt = createdAt,
        lastModifiedAt = lastModifiedAt,
        concealedAt = concealedAt
    )

    fun fromDataTransferObject(dto: ResumeDTO, now: Instant) {
        when(dto) {
            is ResumeDTO.Post -> fromDataTransferObject(dto, now)
            is ResumeDTO.Put -> fromDataTransferObject(dto, now)
        }
    }

    private fun fromDataTransferObject(dto: ResumeDTO.Post, now: Instant) {
        this.companyName = dto.companyName
        this.body = dto.body
        this.startDate = dto.startDate
        this.endDate = dto.endDate
        this.link = dto.link
        this.createdAt = now
    }

    private fun fromDataTransferObject(dto: ResumeDTO.Put, now: Instant) {
        this.companyName = dto.companyName
        this.body = dto.body
        this.startDate = dto.startDate
        this.endDate = dto.endDate
        this.link = dto.link
        this.lastModifiedAt = now
    }
}