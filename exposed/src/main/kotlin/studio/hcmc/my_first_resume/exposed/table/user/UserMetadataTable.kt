package studio.hcmc.my_first_resume.exposed.table.user

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp

object UserMetadataTable : LongIdTable() {
    val resumeCount = integer("resumeCount")
    val portfolioCount = integer("portfolioCount")
    val memoCount = integer("memoCount")
    val articleCount = integer("articleCount")
    val commentCount = integer("commentCount")
    val lastModifiedAt = timestamp("lastModifiedAt").nullable()
}