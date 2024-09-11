package studio.hcmc.my_first_resume.module.domain.portfolio

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import studio.hcmc.my_first_resume.module.domain.user.UserDomain
import studio.hcmc.my_first_resume.module.id.portfolio.PortfolioId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.Concealable
import studio.hcmc.my_first_resume.module.util.Creatable
import studio.hcmc.my_first_resume.module.util.Modifiable

interface PortfolioDomain<Id, UserId> : Creatable, Modifiable, Concealable {
    val id: Id
    val userId: UserId
    val title: String
    val startDate: LocalDate?
    val endDate: LocalDate?
    val isCollaboration: Boolean
    val body: String
    override val createdAt: Instant
    override val lastModifiedAt: Instant?
    override val concealedAt: Instant?

    interface Verbose<Id, UserId> : PortfolioDomain<Id, UserId> {
        override val id: Id
        override val userId: UserId
        val user: UserDomain.Verbose<UserId>
        override val title: String
        override val startDate: LocalDate?
        override val endDate: LocalDate?
        override val isCollaboration: Boolean
        override val body: String
        override val createdAt: Instant
        override val lastModifiedAt: Instant?
        override val concealedAt: Instant?
    }
}

typealias Portfolio = PortfolioDomain<PortfolioId, UserId>
typealias PortfolioVerbose = PortfolioDomain.Verbose<PortfolioId, UserId>