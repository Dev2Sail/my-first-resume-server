package studio.hcmc.my_first_resume.module.domain.portfolio

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.domain.user.UserDomain
import studio.hcmc.my_first_resume.module.id.portfolio.PortfolioId
import studio.hcmc.my_first_resume.module.id.portfolio.PortfolioSkillId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Concealable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Creatable

interface PortfolioSkillDomain<Id, PortfolioId, UserId> : Creatable, Concealable {
    val id: Id
    val portfolioId: PortfolioId
    val userId: UserId
    val body: String
    override val createdAt: Instant
    override val concealedAt: Instant?

    interface Verbose<Id, PortfolioId, UserId> : PortfolioSkillDomain<Id, PortfolioId, UserId> {
        override val id: Id
        override val portfolioId: PortfolioId
        val portfolio: PortfolioDomain.Verbose<PortfolioId, UserId>
        override val userId: UserId
        val user: UserDomain.Verbose<UserId>
        override val body: String
        override val createdAt: Instant
        override val concealedAt: Instant?
    }
}

typealias PortfolioSkill = PortfolioSkillDomain<PortfolioSkillId, PortfolioId, UserId>
typealias PortfolioSkillVerbose = PortfolioSkillDomain.Verbose<PortfolioSkillId, PortfolioId, UserId>