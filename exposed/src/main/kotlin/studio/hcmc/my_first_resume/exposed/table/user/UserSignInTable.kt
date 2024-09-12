package studio.hcmc.my_first_resume.exposed.table.user

import kotlinx.datetime.Clock
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp
import studio.hcmc.my_first_resume.exposed.table.env.EnvApplicationVersionTable

object UserSignInTable : LongIdTable() {
    val userId = reference("userId", UserTable.id)
    val remoteAddress = char("remoteAddress", 15)
    val envApplicationVersionId = reference("envApplicationVersionId", EnvApplicationVersionTable.id)
    val deviceName = varchar("deviceName", 200)
    val deviceVersion = varchar("deviceVersion", 200)
    val createdAt = timestamp("createdAt").clientDefault { Clock.System.now() }
}