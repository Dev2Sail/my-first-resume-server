package studio.hcmc.my_first_resume.exposed.entity.portfolio

import kotlinx.datetime.Instant
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import studio.hcmc.my_first_resume.exposed.repository.portfolio.PortfolioRepository
import studio.hcmc.my_first_resume.exposed.repository.user.UserRepository
import studio.hcmc.my_first_resume.exposed.table.portfolio.PortfolioLinkTable
import studio.hcmc.my_first_resume.module.domain.portfolio.PortfolioLinkDomain
import studio.hcmc.my_first_resume.module.dto.portfolio.PortfolioLinkDTO
import studio.hcmc.my_first_resume.module.id.portfolio.PortfolioId
import studio.hcmc.my_first_resume.module.id.portfolio.PortfolioLinkId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObjectConverter
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObjectConverter
import studio.hcmc.my_first_resume.module.vo.portfolio.PortfolioLinkVO

class PortfolioLinkEntity(id: EntityID<Long>) :
    LongEntity(id),
    PortfolioLinkDomain.Verbose<EntityID<Long>, EntityID<Long>, EntityID<Long>>,
    ValueObjectConverter<PortfolioLinkVO>,
    VerboseValueObjectConverter<PortfolioLinkVO.Verbose>
{
    override var portfolioId by PortfolioLinkTable.portfolioId
    override val portfolio by PortfolioRepository referencedOn PortfolioLinkTable.portfolioId
    override var userId by PortfolioLinkTable.userId
    override val user by UserRepository referencedOn PortfolioLinkTable.userId
    override var body by PortfolioLinkTable.body
    override var createdAt by PortfolioLinkTable.createdAt
    override var concealedAt by PortfolioLinkTable.concealedAt

    override fun toValueObject() = PortfolioLinkVO(
        id = PortfolioLinkId(id.value),
        portfolioId = PortfolioId(portfolioId.value),
        userId = UserId(userId.value),
        body = body,
        createdAt = createdAt,
        concealedAt = concealedAt
    )

    override fun toVerboseValueObject() = PortfolioLinkVO.Verbose(
        id = PortfolioLinkId(id.value),
        portfolioId = PortfolioId(portfolioId.value),
        portfolio = portfolio.toVerboseValueObject(),
        userId = UserId(userId.value),
        user = user.toVerboseValueObject(),
        body = body,
        createdAt = createdAt,
        concealedAt = concealedAt
    )

    fun fromDataTransferObject(dto: PortfolioLinkDTO, now: Instant) {
        when(dto) {
            is PortfolioLinkDTO.Post -> fromDataTransferObject(dto, now)
        }
    }

    private fun fromDataTransferObject(dto: PortfolioLinkDTO.Post, now: Instant) {
        this.body = dto.body
        this.createdAt = now
    }
}