package studio.hcmc.my_first_resume.module.dto.article

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.DataTransferObject

sealed interface ArticleSearchDTO : DataTransferObject {
    @Serializable
    data class Post(
        val body: String
    ) : ArticleSearchDTO
}