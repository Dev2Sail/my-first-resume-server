package studio.hcmc.my_first_resume.module.vo.portfolio

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.portfolio.Portfolio
import studio.hcmc.my_first_resume.module.domain.portfolio.PortfolioVerbose
import studio.hcmc.my_first_resume.module.id.portfolio.PortfolioId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.ValueObject
import studio.hcmc.my_first_resume.module.util.VerboseValueObject
import studio.hcmc.my_first_resume.module.vo.user.UserVO

@Serializable
data class PortfolioVO(
    override val id: PortfolioId,
    override val userId: UserId,
    override val title: String,
    override val startDate: LocalDate?,
    override val endDate: LocalDate?,
    override val isCollaboration: Boolean,
    override val body: String,
    override val createdAt: Instant,
    override val lastModifiedAt: Instant?,
    override val concealedAt: Instant?
) : ValueObject, Portfolio {
    @Serializable
    data class Verbose(
        override val id: PortfolioId,
        override val userId: UserId,
        override val user: UserVO.Verbose,
        override val title: String,
        override val startDate: LocalDate?,
        override val endDate: LocalDate?,
        override val isCollaboration: Boolean,
        override val body: String,
        override val createdAt: Instant,
        override val lastModifiedAt: Instant?,
        override val concealedAt: Instant?
    ) : VerboseValueObject, PortfolioVerbose
}
