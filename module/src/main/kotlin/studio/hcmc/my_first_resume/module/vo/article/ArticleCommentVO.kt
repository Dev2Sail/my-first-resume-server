package studio.hcmc.my_first_resume.module.vo.article

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.article.ArticleComment
import studio.hcmc.my_first_resume.module.domain.article.ArticleCommentVerbose
import studio.hcmc.my_first_resume.module.id.article.ArticleCommentId
import studio.hcmc.my_first_resume.module.id.article.ArticleId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.ValueObject
import studio.hcmc.my_first_resume.module.util.VerboseValueObject
import studio.hcmc.my_first_resume.module.vo.user.UserVO

@Serializable
data class ArticleCommentVO(
    override val id: ArticleCommentId,
    override val articleId: ArticleId,
    override val userId: UserId,
    override val parentId: ArticleCommentId?,
    override val body: String,
    override val createdAt: Instant,
    override val lastModifiedAt: Instant?,
    override val concealedAt: Instant?
) : ValueObject, ArticleComment {
    @Serializable
    data class Verbose(
        override val id: ArticleCommentId,
        override val articleId: ArticleId,
        override val article: ArticleVO.Verbose,
        override val userId: UserId,
        override val user: UserVO.Verbose,
        override val parentId: ArticleCommentId?,
        override val body: String,
        override val metadata: ArticleCommentMetadataVO.Verbose,
        override val createdAt: Instant,
        override val lastModifiedAt: Instant?,
        override val concealedAt: Instant?
    ) : VerboseValueObject, ArticleCommentVerbose
}
