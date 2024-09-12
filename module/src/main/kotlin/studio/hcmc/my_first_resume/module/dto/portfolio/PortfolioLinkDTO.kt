package studio.hcmc.my_first_resume.module.dto.portfolio

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.DataTransferObject

sealed interface PortfolioLinkDTO : DataTransferObject {
    @Serializable
    data class Post(
        val body: String
    ) : PortfolioLinkDTO
}