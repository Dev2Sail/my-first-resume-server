package studio.hcmc.my_first_resume.exposed.entity.resume

import kotlinx.datetime.Instant
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import studio.hcmc.my_first_resume.exposed.repository.user.UserRepository
import studio.hcmc.my_first_resume.exposed.table.resume.ResumeSearchTable
import studio.hcmc.my_first_resume.module.domain.resume.ResumeSearchDomain
import studio.hcmc.my_first_resume.module.dto.resume.ResumeSearchDTO
import studio.hcmc.my_first_resume.module.id.resume.ResumeSearchId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObjectConverter
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObjectConverter
import studio.hcmc.my_first_resume.module.vo.resume.ResumeSearchVO

class ResumeSearchEntity(id: EntityID<Long>) :
    LongEntity(id),
    ResumeSearchDomain.Verbose<EntityID<Long>, EntityID<Long>>,
    ValueObjectConverter<ResumeSearchVO>,
    VerboseValueObjectConverter<ResumeSearchVO.Verbose>
{
    override var userId by ResumeSearchTable.userId
    override val user by UserRepository referencedOn ResumeSearchTable.userId
    override var body by ResumeSearchTable.body
    override var createdAt by ResumeSearchTable.createdAt

    override fun toValueObject() = ResumeSearchVO(
        id = ResumeSearchId(id.value),
        userId = UserId(userId.value),
        body = body,
        createdAt = createdAt
    )

    override fun toVerboseValueObject() = ResumeSearchVO.Verbose(
        id = ResumeSearchId(id.value),
        userId = UserId(userId.value),
        user = user.toVerboseValueObject(),
        body = body,
        createdAt = createdAt
    )

    fun fromDataTransferObject(dto: ResumeSearchDTO, now: Instant) {
        when(dto) {
            is ResumeSearchDTO.Post -> fromDataTransferObject(dto, now)
        }
    }

    private fun fromDataTransferObject(dto: ResumeSearchDTO.Post, now: Instant) {
        this.body = dto.body
        this.createdAt = now
    }
}