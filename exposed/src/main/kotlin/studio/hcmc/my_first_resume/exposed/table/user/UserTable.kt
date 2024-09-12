package studio.hcmc.my_first_resume.exposed.table.user

import kotlinx.datetime.Clock
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp

object UserTable : LongIdTable() {
    val email = varchar("email", 200).uniqueIndex()
    val password = char("password", 128)
    val passwordSalt = char("passwordSalt", 8)
    val nickname = varchar("nickname", 20)
    val createdAt = timestamp("createdAt").clientDefault { Clock.System.now() }
    val lastModifiedAt = timestamp("lastModifiedAt").nullable()
}