package studio.hcmc.my_first_resume.exposed.table.memo

import kotlinx.datetime.Clock
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp
import studio.hcmc.my_first_resume.exposed.table.user.UserTable

object MemoSearchTable : LongIdTable() {
    val userId = reference("userId", UserTable.id)
    val body = varchar("body", 100)
    val createdAt = timestamp("createdAt").clientDefault { Clock.System.now() }
}