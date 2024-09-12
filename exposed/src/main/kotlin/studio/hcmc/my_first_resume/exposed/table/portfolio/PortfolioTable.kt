package studio.hcmc.my_first_resume.exposed.table.portfolio

import kotlinx.datetime.Clock
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.date
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp
import studio.hcmc.my_first_resume.exposed.table.user.UserTable

object PortfolioTable : LongIdTable() {
    val userId = reference("userId", UserTable.id)
    val title = varchar("title", 300)
    val startDate = date("startDate").nullable()
    val endDate = date("endDate").nullable()
    val isCollaboration = bool("isCollaboration")
    val body = text("body")
    val createdAt = timestamp("createdAt").clientDefault { Clock.System.now() }
    val lastModifiedAt = timestamp("lastModifiedAt").nullable()
    val concealedAt = timestamp("concealedAt").nullable()
}