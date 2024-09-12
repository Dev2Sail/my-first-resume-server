package studio.hcmc.my_first_resume.exposed.entity.env

import kotlinx.datetime.Instant
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import studio.hcmc.my_first_resume.exposed.repository.user.UserRepository
import studio.hcmc.my_first_resume.exposed.table.env.EnvApplicationVersionTable
import studio.hcmc.my_first_resume.module.domain.env.EnvApplicationVersionDomain
import studio.hcmc.my_first_resume.module.dto.env.EnvApplicationVersionDTO
import studio.hcmc.my_first_resume.module.id.env.EnvApplicationVersionId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObjectConverter
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObjectConverter
import studio.hcmc.my_first_resume.module.vo.env.EnvApplicationVersionVO

class EnvApplicationVersionEntity(id: EntityID<Long>) :
    LongEntity(id),
    EnvApplicationVersionDomain.Verbose<EntityID<Long>, EntityID<Long>>,
    ValueObjectConverter<EnvApplicationVersionVO>,
    VerboseValueObjectConverter<EnvApplicationVersionVO.Verbose>
{
    override var creatorId by EnvApplicationVersionTable.creatorId
    override var creator by UserRepository referencedOn EnvApplicationVersionTable.creatorId
    override var name by EnvApplicationVersionTable.name
    override var platform by EnvApplicationVersionTable.platform
    override var distribution by EnvApplicationVersionTable.distribution
    override var expiredAt by EnvApplicationVersionTable.expiredAt
    override var createdAt by EnvApplicationVersionTable.createdAt
    override var lastModifiedAt by EnvApplicationVersionTable.lastModifiedAt

    override fun toValueObject() = EnvApplicationVersionVO(
        id = EnvApplicationVersionId(id.value),
        creatorId = UserId(creatorId.value),
        name = name,
        platform = platform,
        distribution = distribution,
        expiredAt = expiredAt,
        createdAt = createdAt,
        lastModifiedAt = lastModifiedAt
    )

    override fun toVerboseValueObject() = EnvApplicationVersionVO.Verbose(
        EnvApplicationVersionId(id.value),
        UserId(creatorId.value),
        creator = creator.toVerboseValueObject(),
        name = name,
        platform = platform,
        distribution = distribution,
        expiredAt = expiredAt,
        createdAt = createdAt,
        lastModifiedAt = lastModifiedAt
    )

    fun fromDataTransferObject(dto: EnvApplicationVersionDTO, now: Instant) {
        when(dto) {
            is EnvApplicationVersionDTO.Post -> fromDataTransferObject(dto, now)
            is EnvApplicationVersionDTO.Put -> fromDataTransferObject(dto, now)
        }
    }

    private fun fromDataTransferObject(dto: EnvApplicationVersionDTO.Post, now: Instant) {
        this.name = dto.name
        this.platform = dto.platform
        this.distribution = dto.distribution
        this.expiredAt = dto.expiredAt
        this.createdAt = now
    }

    private fun fromDataTransferObject(dto: EnvApplicationVersionDTO.Put, now: Instant) {
        this.name = dto.name
        this.expiredAt = dto.expiredAt
        this.lastModifiedAt = now
    }
}