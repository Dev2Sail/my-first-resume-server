package studio.hcmc.my_first_resume.exposed.repository.resume

import org.jetbrains.exposed.dao.LongEntityClass
import studio.hcmc.my_first_resume.exposed.entity.resume.ResumeSubjectAnswerEntity
import studio.hcmc.my_first_resume.exposed.table.resume.ResumeSubjectAnswerTable
import studio.hcmc.my_first_resume.module.dto.resume.ResumeSubjectAnswerNotFound
import studio.hcmc.my_first_resume.module.id.resume.ResumeSubjectAnswerId

object ResumeSubjectAnswerRepository : LongEntityClass<ResumeSubjectAnswerEntity>(
    ResumeSubjectAnswerTable,
    ResumeSubjectAnswerEntity::class.java
) {
    fun findById(id: ResumeSubjectAnswerId) : ResumeSubjectAnswerEntity {
        return findById(id.value) ?: throw ResumeSubjectAnswerNotFound
    }
}