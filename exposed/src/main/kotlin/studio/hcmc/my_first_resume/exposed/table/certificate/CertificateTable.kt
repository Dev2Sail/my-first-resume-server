package studio.hcmc.my_first_resume.exposed.table.certificate

import kotlinx.datetime.Clock
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.date
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp
import studio.hcmc.my_first_resume.exposed.table.user.UserTable

object CertificateTable : LongIdTable() {
    val userId = reference("userId", UserTable.id)
    val title = varchar("title", 100)
    val code = varchar("code", 100)
    val level = varchar("level", 100)
    val organization = varchar("organization", 100)
    val acquiredDate = date("acquiredDate")
    val createdAt = timestamp("createdAt").clientDefault { Clock.System.now() }
    val lastModifiedAt = timestamp("lastModifiedAt").nullable()
    val concealedAt = timestamp("concealedAt").nullable()
}