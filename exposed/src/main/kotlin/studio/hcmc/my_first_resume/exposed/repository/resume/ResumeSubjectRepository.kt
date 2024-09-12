package studio.hcmc.my_first_resume.exposed.repository.resume

import org.jetbrains.exposed.dao.LongEntityClass
import studio.hcmc.my_first_resume.exposed.entity.resume.ResumeSubjectEntity
import studio.hcmc.my_first_resume.exposed.table.resume.ResumeSubjectTable
import studio.hcmc.my_first_resume.module.dto.resume.ResumeSubjectNotFound
import studio.hcmc.my_first_resume.module.id.resume.ResumeSubjectId

object ResumeSubjectRepository : LongEntityClass<ResumeSubjectEntity>(
    ResumeSubjectTable,
    ResumeSubjectEntity::class.java
) {
    fun findById(id: ResumeSubjectId) : ResumeSubjectEntity {
        return findById(id.value) ?: throw ResumeSubjectNotFound
    }
}