package studio.hcmc.my_first_resume.exposed.entity.certificate

import kotlinx.datetime.Instant
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import studio.hcmc.my_first_resume.exposed.repository.user.UserRepository
import studio.hcmc.my_first_resume.exposed.table.certificate.CertificateTable
import studio.hcmc.my_first_resume.module.domain.certificate.CertificateDomain
import studio.hcmc.my_first_resume.module.dto.certificate.CertificateDTO
import studio.hcmc.my_first_resume.module.id.certificate.CertificateId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObjectConverter
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObjectConverter
import studio.hcmc.my_first_resume.module.vo.certificate.CertificateVO

class CertificateEntity(id: EntityID<Long>) :
    LongEntity(id),
    CertificateDomain.Verbose<EntityID<Long>, EntityID<Long>>,
    ValueObjectConverter<CertificateVO>,
    VerboseValueObjectConverter<CertificateVO.Verbose>
{

    override var userId by CertificateTable.userId
    override val user by UserRepository referencedOn CertificateTable.userId
    override var title by CertificateTable.title
    override var code by CertificateTable.code
    override var level by CertificateTable.level
    override var organization by CertificateTable.organization
    override var acquireDate by CertificateTable.acquiredDate
    override var createdAt by CertificateTable.createdAt
    override var lastModifiedAt by CertificateTable.lastModifiedAt
    override var concealedAt by CertificateTable.concealedAt

    override fun toValueObject() = CertificateVO(
        id = CertificateId(id.value),
        userId = UserId(userId.value),
        title = title,
        code = code,
        level = level,
        organization = organization,
        acquireDate = acquireDate,
        createdAt = createdAt,
        lastModifiedAt = lastModifiedAt,
        concealedAt = concealedAt
    )

    override fun toVerboseValueObject() = CertificateVO.Verbose(
        id = CertificateId(id.value),
        userId = UserId(userId.value),
        user = user.toVerboseValueObject(),
        title = title,
        code = code,
        level = level,
        organization = organization,
        acquireDate = acquireDate,
        createdAt = createdAt,
        lastModifiedAt = lastModifiedAt,
        concealedAt = concealedAt
    )

    fun fromDataTransferObject(dto: CertificateDTO, now: Instant) {
        when(dto) {
            is CertificateDTO.Post -> fromDataTransferObject(dto, now)
            is CertificateDTO.Put -> fromDataTransferObject(dto, now)
        }
    }

    private fun fromDataTransferObject(dto: CertificateDTO.Post, now: Instant) {
        this.title = dto.title
        this.code = dto.code
        this.organization = dto.organization
        this.acquireDate = dto.acquiredDate
        this.createdAt = now
    }

    private fun fromDataTransferObject(dto: CertificateDTO.Put, now: Instant) {
        this.title = dto.title
        this.code = dto.code
        this.organization = dto.organization
        this.acquireDate = dto.acquiredDate
        this.lastModifiedAt = now
    }
}