package studio.hcmc.my_first_resume.exposed.table.article

import kotlinx.datetime.Clock
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp
import studio.hcmc.my_first_resume.exposed.table.user.UserTable

object ArticleCommentAnonymousTable : LongIdTable() {
    val articleId = reference("articleId", ArticleTable.id)
    val userId = reference("userId", UserTable.id)
    val index = integer("index")
    val createdAt = timestamp("createdAt").clientDefault { Clock.System.now() }
}