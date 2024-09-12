package studio.hcmc.my_first_resume.exposed.table.article

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp

object ArticleMetadataTable : LongIdTable() {
    val commentCount = integer("commentCount")
    val lastModifiedAt = timestamp("lastModifiedAt").nullable()
}