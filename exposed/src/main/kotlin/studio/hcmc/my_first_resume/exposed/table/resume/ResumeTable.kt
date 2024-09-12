package studio.hcmc.my_first_resume.exposed.table.resume

import kotlinx.datetime.Clock
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.datetime
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp
import studio.hcmc.my_first_resume.exposed.table.user.UserTable
import studio.hcmc.my_first_resume.module.domain.resume.ResumeDomain

object ResumeTable : LongIdTable() {
    val userId = reference("userId", UserTable.id)
    val companyName = varchar("companyName", 200)
    val body = varchar("body", 200)
    val startDate = datetime("startDate")
    val endDate = datetime("endDate")
    val link = varchar("link", 400)
    val isSubmit = bool("isSubmit")
    val status = enumeration<ResumeDomain.Status>("status")
    val createdAt = timestamp("createdAt").clientDefault { Clock.System.now() }
    val lastModifiedAt = timestamp("lastModifiedAt").nullable()
    val concealedAt = timestamp("concealedAt").nullable()
}