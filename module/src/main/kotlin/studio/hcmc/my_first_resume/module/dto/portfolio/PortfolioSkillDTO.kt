package studio.hcmc.my_first_resume.module.dto.portfolio

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.DataTransferObject

sealed interface PortfolioSkillDTO : DataTransferObject {
    @Serializable
    data class Post(
        val body: String
    ) : PortfolioSkillDTO
}