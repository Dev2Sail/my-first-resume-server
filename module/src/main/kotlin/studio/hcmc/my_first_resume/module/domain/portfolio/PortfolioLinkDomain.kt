package studio.hcmc.my_first_resume.module.domain.portfolio

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.domain.user.UserDomain
import studio.hcmc.my_first_resume.module.id.portfolio.PortfolioId
import studio.hcmc.my_first_resume.module.id.portfolio.PortfolioLinkId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.Concealable
import studio.hcmc.my_first_resume.module.util.Creatable

interface PortfolioLinkDomain<Id, PortfolioId, UserId> : Creatable, Concealable {
    val id: Id
    val portfolioId: PortfolioId
    val userId: UserId
    val body: String
    override val createdAt: Instant
    override val concealedAt: Instant?

    interface Verbose<Id, PortfolioId, UserId> : PortfolioLinkDomain<Id, PortfolioId, UserId> {
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

typealias PortfolioLink = PortfolioLinkDomain<PortfolioLinkId, PortfolioId, UserId>
typealias PortfolioLinkVerbose = PortfolioLinkDomain.Verbose<PortfolioLinkId, PortfolioId, UserId>