package studio.hcmc.my_first_resume.exposed.entity.portfolio

import kotlinx.datetime.Instant
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import studio.hcmc.my_first_resume.exposed.repository.user.UserRepository
import studio.hcmc.my_first_resume.exposed.table.portfolio.PortfolioTable
import studio.hcmc.my_first_resume.module.domain.portfolio.PortfolioDomain
import studio.hcmc.my_first_resume.module.dto.portfolio.PortfolioDTO
import studio.hcmc.my_first_resume.module.id.portfolio.PortfolioId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObjectConverter
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObjectConverter
import studio.hcmc.my_first_resume.module.vo.portfolio.PortfolioVO

class PortfolioEntity(id: EntityID<Long>) :
    LongEntity(id),
    PortfolioDomain.Verbose<EntityID<Long>, EntityID<Long>>,
    ValueObjectConverter<PortfolioVO>,
    VerboseValueObjectConverter<PortfolioVO.Verbose>
{
    override var userId by PortfolioTable.userId
    override val user by UserRepository referencedOn PortfolioTable.userId
    override var title by PortfolioTable.title
    override var startDate by PortfolioTable.startDate
    override var endDate by PortfolioTable.endDate
    override var isCollaboration by PortfolioTable.isCollaboration
    override var body by PortfolioTable.body
    override var createdAt by PortfolioTable.createdAt
    override var lastModifiedAt by PortfolioTable.lastModifiedAt
    override var concealedAt by PortfolioTable.concealedAt

    override fun toValueObject() = PortfolioVO(
        id = PortfolioId(id.value),
        userId = UserId(userId.value),
        title = title,
        startDate = startDate,
        endDate = endDate,
        isCollaboration = isCollaboration,
        body = body,
        createdAt = createdAt,
        lastModifiedAt = lastModifiedAt,
        concealedAt = concealedAt
    )

    override fun toVerboseValueObject() = PortfolioVO.Verbose(
        id = PortfolioId(id.value),
        userId = UserId(userId.value),
        user = user.toVerboseValueObject(),
        title = title,
        startDate = startDate,
        endDate = endDate,
        isCollaboration = isCollaboration,
        body = body,
        createdAt = createdAt,
        lastModifiedAt = lastModifiedAt,
        concealedAt = concealedAt
    )

    fun fromDataTransferObject(dto: PortfolioDTO, now: Instant) {
        when(dto) {
            is PortfolioDTO.Post -> fromDataTransferObject(dto, now)
            is PortfolioDTO.Put -> fromDataTransferObject(dto, now)
        }
    }

    private fun fromDataTransferObject(dto: PortfolioDTO.Post, now: Instant) {
        this.title = dto.title
        this.startDate = dto.startDate
        this.endDate = dto.endDate
        this.isCollaboration = dto.isCollaboration
        this.body = dto.body
        this.createdAt = now
    }

    private fun fromDataTransferObject(dto: PortfolioDTO.Put, now: Instant) {
        this.title = dto.title
        this.startDate = dto.startDate
        this.endDate = dto.endDate
        this.isCollaboration = dto.isCollaboration
        this.body = dto.body
        this.lastModifiedAt = now
    }
}