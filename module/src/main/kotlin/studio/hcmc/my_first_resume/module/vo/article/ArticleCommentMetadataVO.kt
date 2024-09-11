package studio.hcmc.my_first_resume.module.vo.article

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.article.ArticleCommentMetadata
import studio.hcmc.my_first_resume.module.domain.article.ArticleCommentMetadataVerbose
import studio.hcmc.my_first_resume.module.id.article.ArticleCommentId
import studio.hcmc.my_first_resume.module.util.ValueObject
import studio.hcmc.my_first_resume.module.util.VerboseValueObject

@Serializable
data class ArticleCommentMetadataVO(
    override val id: ArticleCommentId,
    override val commentCount: Int,
    override val lastModifiedAt: Instant?
) : ValueObject, ArticleCommentMetadata {
    @Serializable
    data class Verbose(
        override val id: ArticleCommentId,
        override val commentCount: Int,
        override val lastModifiedAt: Instant?
    ) : VerboseValueObject, ArticleCommentMetadataVerbose
}
