package studio.hcmc.my_first_resume.module.vo.article

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.article.Article
import studio.hcmc.my_first_resume.module.domain.article.ArticleVerbose
import studio.hcmc.my_first_resume.module.id.article.ArticleId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.ValueObject
import studio.hcmc.my_first_resume.module.util.VerboseValueObject
import studio.hcmc.my_first_resume.module.vo.user.UserVO

@Serializable
data class ArticleVO(
    override val id: ArticleId,
    override val userId: UserId,
    override val title: String,
    override val body: String,
    override val createdAt: Instant,
    override val lastModifiedAt: Instant?,
    override val concealedAt: Instant?
) : ValueObject, Article {
    @Serializable
    data class Verbose(
        override val id: ArticleId,
        override val userId: UserId,
        override val user: UserVO.Verbose,
        override val title: String,
        override val body: String,
        override val metadata: ArticleMetadataVO.Verbose,
        override val createdAt: Instant,
        override val lastModifiedAt: Instant?,
        override val concealedAt: Instant?
    ) : VerboseValueObject, ArticleVerbose
}
