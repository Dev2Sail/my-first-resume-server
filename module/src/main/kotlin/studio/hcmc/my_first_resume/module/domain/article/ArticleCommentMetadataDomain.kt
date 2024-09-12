package studio.hcmc.my_first_resume.module.domain.article

import kotlinx.datetime.Instant
import studio.hcmc.my_first_resume.module.id.article.ArticleCommentId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.Modifiable

interface ArticleCommentMetadataDomain<Id> : Modifiable {
    val id: Id
    val commentCount: Int
    override val lastModifiedAt: Instant?

    interface Verbose<Id> : ArticleCommentMetadataDomain<Id> {
        override val id: Id
        override val commentCount: Int
        override val lastModifiedAt: Instant?
    }
}

typealias ArticleCommentMetadata = ArticleCommentMetadataDomain<ArticleCommentId>
typealias ArticleCommentMetadataVerbose = ArticleCommentMetadataDomain.Verbose<ArticleCommentId>