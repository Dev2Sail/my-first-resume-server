package studio.hcmc.my_first_resume.exposed.table.env

import kotlinx.datetime.Clock
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp
import studio.hcmc.my_first_resume.exposed.table.user.UserTable
import studio.hcmc.my_first_resume.module.domain.env.EnvApplicationVersionDomain

object EnvApplicationVersionTable : LongIdTable() {
    val creatorId = reference("creatorId", UserTable.id)
    val name = varchar("name", 20)
    val platform = enumeration<EnvApplicationVersionDomain.Platform>("platform")
    val distribution = enumeration<EnvApplicationVersionDomain.Distribution>("distribution")
    val expiredAt = timestamp("expiredAt").nullable()
    val createdAt = timestamp("createdAt").clientDefault { Clock.System.now() }
    val lastModifiedAt = timestamp("lastModifiedAt").nullable()
}