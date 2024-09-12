package studio.hcmc.my_first_resume.exposed.repository.resume

import org.jetbrains.exposed.dao.LongEntityClass
import studio.hcmc.my_first_resume.exposed.entity.resume.ResumeSearchEntity
import studio.hcmc.my_first_resume.exposed.table.resume.ResumeSearchTable
import studio.hcmc.my_first_resume.module.dto.resume.ResumeNotFound
import studio.hcmc.my_first_resume.module.id.resume.ResumeSearchId

object ResumeSearchRepository : LongEntityClass<ResumeSearchEntity>(
    ResumeSearchTable,
    ResumeSearchEntity::class.java
) {
    fun findById(id: ResumeSearchId) : ResumeSearchEntity {
        return findById(id.value) ?: throw ResumeNotFound
    }
}