package studio.hcmc.my_first_resume.module.vo.article

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.article.ArticleSearch
import studio.hcmc.my_first_resume.module.domain.article.ArticleSearchVerbose
import studio.hcmc.my_first_resume.module.id.article.ArticleSearchId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.ValueObject
import studio.hcmc.my_first_resume.module.util.VerboseValueObject
import studio.hcmc.my_first_resume.module.vo.user.UserVO

@Serializable
data class ArticleSearchVO(
    override val id: ArticleSearchId,
    override val userId: UserId,
    override val body: String,
    override val createdAt: Instant
) : ValueObject, ArticleSearch {
    @Serializable
    data class Verbose(
        override val id: ArticleSearchId,
        override val userId: UserId,
        override val user: UserVO.Verbose,
        override val body: String,
        override val createdAt: Instant
    ) : VerboseValueObject, ArticleSearchVerbose
}
