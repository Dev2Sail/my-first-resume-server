package studio.hcmc.my_first_resume.exposed.table.resume

import kotlinx.datetime.Clock
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp

object ResumeSubjectAnswerTable : LongIdTable() {
    val resumeSubjectId = reference("resumeSubjectId", ResumeSubjectTable.id)
    val resumeId = reference("resumeId", ResumeTable.id)
    val body = varchar("body", 3000)
    val createdAt = timestamp("createdAt").clientDefault { Clock.System.now() }
    val lastModifiedAt = timestamp("lastModifiedAt").nullable()
    val concealedAt =  timestamp("concealedAt").nullable()
}