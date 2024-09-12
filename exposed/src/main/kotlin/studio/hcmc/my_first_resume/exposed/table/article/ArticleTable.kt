package studio.hcmc.my_first_resume.exposed.table.article

import kotlinx.datetime.Clock
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp
import studio.hcmc.my_first_resume.exposed.table.user.UserTable

object ArticleTable : LongIdTable() {
    val userId = reference("userId", UserTable.id)
    val title = varchar("title", 50)
    val body = varchar("body", 1000)
    val createdAt = timestamp("createdAt").clientDefault { Clock.System.now() }
    val lastModifiedAt = timestamp("lastModifiedAt").nullable()
    val concealedAt = timestamp("concealedAt").nullable()
}