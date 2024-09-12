package studio.hcmc.my_first_resume.exposed.table.portfolio

import kotlinx.datetime.Clock
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp
import studio.hcmc.my_first_resume.exposed.table.user.UserTable

object PortfolioLinkTable : LongIdTable() {
    val portfolioId = reference("portfolioId", PortfolioTable.id)
    val userId = reference("userId", UserTable.id)
    val body = varchar("body", 400)
    val createdAt = timestamp("createdAt").clientDefault { Clock.System.now() }
    val concealedAt = timestamp("concealedAt").nullable()
}