package studio.hcmc.my_first_resume.module.domain.article

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.domain.user.UserDomain
import studio.hcmc.my_first_resume.module.id.article.ArticleId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.Concealable
import studio.hcmc.my_first_resume.module.util.Creatable
import studio.hcmc.my_first_resume.module.util.Modifiable

interface ArticleDomain<Id, UserId> : Creatable, Modifiable, Concealable {
    val id: Id
    val userId: UserId
    val title: String
    val body: String
    override val createdAt: Instant
    override val lastModifiedAt: Instant?
    override val concealedAt: Instant?

    interface Verbose<Id, UserId> : ArticleDomain<Id, UserId> {
        override val id: Id
        override val userId: UserId
        val user: UserDomain.Verbose<UserId>
        override val title: String
        override val body: String
        val metadata: ArticleMetadataDomain.Verbose<Id>
        override val createdAt: Instant
        override val lastModifiedAt: Instant?
        override val concealedAt: Instant?
    }
}

typealias Article = ArticleDomain<ArticleId, UserId>
typealias ArticleVerbose = ArticleDomain.Verbose<ArticleId, UserId>