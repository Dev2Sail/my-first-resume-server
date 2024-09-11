package studio.hcmc.my_first_resume.module.domain.article

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.domain.user.UserDomain
import studio.hcmc.my_first_resume.module.id.article.ArticleSearchId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.Creatable

interface ArticleSearchDomain<Id, UserId> : Creatable {
    val id: Id
    val userId: UserId
    val body: String
    override val createdAt: Instant

    interface Verbose<Id, UserId> : ArticleSearchDomain<Id, UserId> {
        override val id: Id
        override val userId: UserId
        val user: UserDomain.Verbose<UserId>
        override val body: String
        override val createdAt: Instant
    }
}

typealias ArticleSearch = ArticleSearchDomain<ArticleSearchId, UserId>
typealias ArticleSearchVerbose = ArticleSearchDomain.Verbose<ArticleSearchId, UserId>