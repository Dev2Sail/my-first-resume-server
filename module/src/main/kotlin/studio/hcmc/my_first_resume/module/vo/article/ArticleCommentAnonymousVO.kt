package studio.hcmc.my_first_resume.module.vo.article

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.article.ArticleCommentAnonymous
import studio.hcmc.my_first_resume.module.domain.article.ArticleCommentAnonymousVerbose
import studio.hcmc.my_first_resume.module.id.article.ArticleCommentAnonymousId
import studio.hcmc.my_first_resume.module.id.article.ArticleId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObject
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObject
import studio.hcmc.my_first_resume.module.vo.user.UserVO

@Serializable
data class ArticleCommentAnonymousVO(
    override val id: ArticleCommentAnonymousId,
    override val articleId: ArticleId,
    override val userId: UserId,
    override val index: Int,
    override val createdAt: Instant
) : ValueObject, ArticleCommentAnonymous {
    @Serializable
    data class Verbose(
        override val id: ArticleCommentAnonymousId,
        override val articleId: ArticleId,
        override val article: ArticleVO.Verbose,
        override val userId: UserId,
        override val user: UserVO.Verbose,
        override val index: Int,
        override val createdAt: Instant
    ) : VerboseValueObject, ArticleCommentAnonymousVerbose
}
