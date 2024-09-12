package studio.hcmc.my_first_resume.exposed.entity.portfolio

import kotlinx.datetime.Instant
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import studio.hcmc.my_first_resume.exposed.repository.portfolio.PortfolioRepository
import studio.hcmc.my_first_resume.exposed.repository.user.UserRepository
import studio.hcmc.my_first_resume.exposed.table.portfolio.PortfolioSkillTable
import studio.hcmc.my_first_resume.module.domain.portfolio.PortfolioSkillDomain
import studio.hcmc.my_first_resume.module.dto.portfolio.PortfolioSkillDTO
import studio.hcmc.my_first_resume.module.id.portfolio.PortfolioId
import studio.hcmc.my_first_resume.module.id.portfolio.PortfolioSkillId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObjectConverter
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObjectConverter
import studio.hcmc.my_first_resume.module.vo.portfolio.PortfolioSkillVO

class PortfolioSkillEntity(id: EntityID<Long>) :
    LongEntity(id),
    PortfolioSkillDomain.Verbose<EntityID<Long>, EntityID<Long>, EntityID<Long>>,
    ValueObjectConverter<PortfolioSkillVO>,
    VerboseValueObjectConverter<PortfolioSkillVO.Verbose>
{
    override var portfolioId by PortfolioSkillTable.portfolioId
    override val portfolio by PortfolioRepository referencedOn PortfolioSkillTable.portfolioId
    override var userId by PortfolioSkillTable.userId
    override val user by UserRepository referencedOn PortfolioSkillTable.userId
    override var body by PortfolioSkillTable.body
    override var createdAt by PortfolioSkillTable.createdAt
    override var concealedAt by PortfolioSkillTable.concealedAt

    override fun toValueObject() = PortfolioSkillVO(
        id = PortfolioSkillId(id.value),
        portfolioId = PortfolioId(portfolioId.value),
        userId = UserId(userId.value),
        body = body,
        createdAt = createdAt,
        concealedAt = concealedAt
    )

    override fun toVerboseValueObject() = PortfolioSkillVO.Verbose(
        id = PortfolioSkillId(id.value),
        portfolioId = PortfolioId(portfolioId.value),
        portfolio = portfolio.toVerboseValueObject(),
        userId = UserId(userId.value),
        user = user.toVerboseValueObject(),
        body = body,
        createdAt = createdAt,
        concealedAt = concealedAt
    )

    fun fromDataTransferObject(dto: PortfolioSkillDTO, now: Instant) {
        when(dto) {
            is PortfolioSkillDTO.Post -> fromDataTransferObject(dto, now)
        }
    }

    private fun fromDataTransferObject(dto: PortfolioSkillDTO.Post, now: Instant) {
        this.body = dto.body
        this.createdAt = now
    }
}