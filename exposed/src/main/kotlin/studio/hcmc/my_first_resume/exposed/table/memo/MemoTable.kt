package studio.hcmc.my_first_resume.exposed.table.memo

import kotlinx.datetime.Clock
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp
import studio.hcmc.my_first_resume.exposed.table.user.UserTable

object MemoTable : LongIdTable() {
    val userId = reference("userId", UserTable.id)
    val body = varchar("body", 2000)
    val createdAt = timestamp("createdAt").clientDefault { Clock.System.now() }
    val lastModifiedAt = timestamp("lastModifiedAt").nullable()
    val concealedAt = timestamp("concealedAt").nullable()
}