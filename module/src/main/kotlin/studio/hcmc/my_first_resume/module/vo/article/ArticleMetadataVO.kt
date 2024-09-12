package studio.hcmc.my_first_resume.module.vo.article

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.article.ArticleMetadata
import studio.hcmc.my_first_resume.module.domain.article.ArticleMetadataVerbose
import studio.hcmc.my_first_resume.module.id.article.ArticleId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObject
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObject

@Serializable
data class ArticleMetadataVO(
    override val id: ArticleId,
    override val commentCount: Int,
    override val lastModifiedAt: Instant?
) : ValueObject, ArticleMetadata {
    @Serializable
    data class Verbose(
        override val id: ArticleId,
        override val commentCount: Int,
        override val lastModifiedAt: Instant?
    ) : VerboseValueObject, ArticleMetadataVerbose
}
