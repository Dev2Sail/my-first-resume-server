package studio.hcmc.my_first_resume.module.domain.article

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.id.article.ArticleId
import studio.hcmc.my_first_resume.module.util.Modifiable

interface ArticleMetadataDomain<Id> : Modifiable {
    val id: Id
    val commentCount: Int
    override val lastModifiedAt: Instant?

    interface Verbose<Id> : ArticleMetadataDomain<Id> {
        override val id: Id
        override val commentCount: Int
        override val lastModifiedAt: Instant?
    }
}

typealias ArticleMetadata = ArticleMetadataDomain<ArticleId>
typealias ArticleMetadataVerbose = ArticleMetadataDomain.Verbose<ArticleId>