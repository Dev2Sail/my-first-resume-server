package studio.hcmc.my_first_resume.module.dto.article

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.DataTransferObject

sealed interface ArticleDTO : DataTransferObject {
    @Serializable
    data class Post(
        val title: String,
        val body: String
    ) : ArticleDTO

    @Serializable
    data class Put(
        val title: String,
        val body: String
    ) : ArticleDTO
}