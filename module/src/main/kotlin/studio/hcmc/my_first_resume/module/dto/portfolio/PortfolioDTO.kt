package studio.hcmc.my_first_resume.module.dto.portfolio

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.DataTransferObject

sealed interface PortfolioDTO : DataTransferObject {
    @Serializable
    data class Post(
        val title: String,
        val startDate: LocalDateTime,
        val endDate: LocalDateTime,
        val isCollaboration: Boolean,
        val body: String
    ) : PortfolioDTO

    @Serializable
    data class Put(
        val title: String,
        val startDate: LocalDateTime,
        val endDate: LocalDateTime,
        val isCollaboration: Boolean,
        val body: String
    ) : PortfolioDTO
}