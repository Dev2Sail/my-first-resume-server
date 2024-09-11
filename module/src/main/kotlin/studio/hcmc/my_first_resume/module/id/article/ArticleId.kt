package studio.hcmc.my_first_resume.module.id.article

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class ArticleId(val value: Long) {
    override fun toString(): String {
        return value.toString()
    }
}
