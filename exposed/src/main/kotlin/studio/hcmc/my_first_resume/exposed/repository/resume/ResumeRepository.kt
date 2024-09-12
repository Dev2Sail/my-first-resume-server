package studio.hcmc.my_first_resume.exposed.repository.resume

import org.jetbrains.exposed.dao.LongEntityClass
import studio.hcmc.my_first_resume.exposed.entity.resume.ResumeEntity
import studio.hcmc.my_first_resume.exposed.table.resume.ResumeTable
import studio.hcmc.my_first_resume.module.dto.resume.ResumeNotFound
import studio.hcmc.my_first_resume.module.id.resume.ResumeId

object ResumeRepository : LongEntityClass<ResumeEntity>(
    ResumeTable,
    ResumeEntity::class.java
) {
    fun findById(id: ResumeId) : ResumeEntity {
        return findById(id.value) ?: throw ResumeNotFound
    }
}