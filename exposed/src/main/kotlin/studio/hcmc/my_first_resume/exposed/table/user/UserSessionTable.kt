package studio.hcmc.my_first_resume.exposed.table.user

import kotlinx.datetime.Clock
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp

object UserSessionTable : LongIdTable() {
    val userSignInId = optReference("userSignInId", UserSignInTable.id)
    val createdAt = timestamp("createdAt").clientDefault { Clock.System.now() }
}