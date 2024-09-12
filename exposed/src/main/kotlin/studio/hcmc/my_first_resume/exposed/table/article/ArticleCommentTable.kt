package studio.hcmc.my_first_resume.exposed.table.article

import kotlinx.datetime.Clock
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp
import studio.hcmc.my_first_resume.exposed.table.user.UserTable

object ArticleCommentTable : LongIdTable() {
    val articleId = reference("articleId", ArticleTable.id)
    val userId = reference("userId", UserTable.id)
    val parentId = optReference("parentId", id)
    val body = varchar("body", 1000)
    val createdAt = timestamp("createdAt").clientDefault { Clock.System.now() }
    val lastModifiedAt = timestamp("lastModifiedAt").nullable()
    val concealedAt = timestamp("concealedAt").nullable()
}