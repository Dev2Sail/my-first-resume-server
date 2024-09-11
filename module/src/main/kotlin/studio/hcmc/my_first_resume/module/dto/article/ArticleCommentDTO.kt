package studio.hcmc.my_first_resume.module.dto.article

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.DataTransferObject

sealed interface ArticleCommentDTO : DataTransferObject {
    @Serializable
    data class Post(
        val body: String
    ) : ArticleCommentDTO

    @Serializable
    data class Put(
        val body: String
    ) : ArticleCommentDTO
}