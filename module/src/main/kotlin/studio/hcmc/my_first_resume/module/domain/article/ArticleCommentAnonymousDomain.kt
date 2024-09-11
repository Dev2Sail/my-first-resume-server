package studio.hcmc.my_first_resume.module.domain.article

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.domain.user.UserDomain
import studio.hcmc.my_first_resume.module.id.article.ArticleCommentAnonymousId
import studio.hcmc.my_first_resume.module.id.article.ArticleId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.Creatable

interface ArticleCommentAnonymousDomain<Id, ArticleId, UserId> : Creatable {
    val id: Id
    val articleId: ArticleId
    val userId: UserId
    val index: Int
    override val createdAt: Instant

    interface Verbose<Id, ArticleId, UserId> : ArticleCommentAnonymousDomain<Id, ArticleId, UserId> {
        override val id: Id
        override val articleId: ArticleId
        val article: ArticleDomain.Verbose<ArticleId, UserId>
        override val userId: UserId
        val user: UserDomain.Verbose<UserId>
        override val index: Int
        override val createdAt: Instant
    }
}

typealias ArticleCommentAnonymous = ArticleCommentAnonymousDomain<ArticleCommentAnonymousId, ArticleId, UserId>
typealias ArticleCommentAnonymousVerbose = ArticleCommentAnonymousDomain.Verbose<ArticleCommentAnonymousId, ArticleId, UserId>