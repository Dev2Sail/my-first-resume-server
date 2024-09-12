package studio.hcmc.my_first_resume.module.domain.article

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.domain.user.UserDomain
import studio.hcmc.my_first_resume.module.id.article.ArticleCommentId
import studio.hcmc.my_first_resume.module.id.article.ArticleId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Concealable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Creatable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Modifiable

interface ArticleCommentDomain<Id, ArticleId, UserId> : Creatable, Modifiable, Concealable {
    val id: Id
    val articleId: ArticleId
    val userId: UserId
    val parentId: Id?
    val body: String
    override val createdAt: Instant
    override val lastModifiedAt: Instant?
    override val concealedAt: Instant?

    interface Verbose<Id, ArticleId, UserId> : ArticleCommentDomain<Id, ArticleId, UserId> {
        override val id: Id
        override val articleId: ArticleId
        val article: ArticleDomain.Verbose<ArticleId, UserId>
        override val userId: UserId
        val user: UserDomain.Verbose<UserId>
        override val parentId: Id?
        override val body: String
        val metadata: ArticleCommentMetadataDomain.Verbose<Id>
        override val createdAt: Instant
        override val lastModifiedAt: Instant?
        override val concealedAt: Instant?
    }
}

typealias ArticleComment = ArticleCommentDomain<ArticleCommentId, ArticleId, UserId>
typealias ArticleCommentVerbose = ArticleCommentDomain.Verbose<ArticleCommentId, ArticleId, UserId>