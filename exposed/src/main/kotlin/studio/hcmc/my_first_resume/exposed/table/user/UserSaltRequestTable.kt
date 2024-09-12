package studio.hcmc.my_first_resume.exposed.table.user

import kotlinx.datetime.Clock
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp

object UserSaltRequestTable : LongIdTable() {
    val email = varchar("email", 200)
    val remoteAddress = char("remoteAddress", 15)
    val createdAt = timestamp("createdAt").clientDefault { Clock.System.now() }
}