package studio.hcmc.my_first_resume.exposed.table.resume

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp

object ResumeMetadataTable : LongIdTable() {
    val subjectCount = integer("subjectCount")
    val isFinishCount = integer("isFinishCount")
    val lastModifiedAt = timestamp("lastModifiedAt").nullable()
}