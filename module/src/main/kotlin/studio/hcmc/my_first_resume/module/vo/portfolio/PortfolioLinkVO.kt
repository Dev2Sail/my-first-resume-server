package studio.hcmc.my_first_resume.module.vo.portfolio

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.portfolio.PortfolioLink
import studio.hcmc.my_first_resume.module.domain.portfolio.PortfolioLinkVerbose
import studio.hcmc.my_first_resume.module.id.portfolio.PortfolioId
import studio.hcmc.my_first_resume.module.id.portfolio.PortfolioLinkId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.ValueObject
import studio.hcmc.my_first_resume.module.util.VerboseValueObject
import studio.hcmc.my_first_resume.module.vo.user.UserVO

@Serializable
data class PortfolioLinkVO(
    override val id: PortfolioLinkId,
    override val portfolioId: PortfolioId,
    override val userId: UserId,
    override val body: String,
    override val createdAt: Instant,
    override val concealedAt: Instant?
) : ValueObject, PortfolioLink {
    @Serializable
    data class Verbose(
        override val id: PortfolioLinkId,
        override val portfolioId: PortfolioId,
        override val portfolio: PortfolioVO.Verbose,
        override val userId: UserId,
        override val user: UserVO.Verbose,
        override val body: String,
        override val createdAt: Instant,
        override val concealedAt: Instant?
    ) : VerboseValueObject, PortfolioLinkVerbose
}
