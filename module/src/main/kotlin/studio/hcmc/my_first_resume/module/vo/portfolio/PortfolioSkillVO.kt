package studio.hcmc.my_first_resume.module.vo.portfolio

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.portfolio.PortfolioSkill
import studio.hcmc.my_first_resume.module.domain.portfolio.PortfolioSkillVerbose
import studio.hcmc.my_first_resume.module.id.portfolio.PortfolioId
import studio.hcmc.my_first_resume.module.id.portfolio.PortfolioSkillId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObject
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObject
import studio.hcmc.my_first_resume.module.vo.user.UserVO

@Serializable
data class PortfolioSkillVO(
    override val id: PortfolioSkillId,
    override val portfolioId: PortfolioId,
    override val userId: UserId,
    override val body: String,
    override val createdAt: Instant,
    override val concealedAt: Instant?
) : ValueObject, PortfolioSkill {
    @Serializable
    data class Verbose(
        override val id: PortfolioSkillId,
        override val portfolioId: PortfolioId,
        override val portfolio: PortfolioVO.Verbose,
        override val userId: UserId,
        override val user: UserVO.Verbose,
        override val body: String,
        override val createdAt: Instant,
        override val concealedAt: Instant?
    ) : VerboseValueObject, PortfolioSkillVerbose
}
