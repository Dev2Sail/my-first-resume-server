package studio.hcmc.my_first_resume.exposed.repository.resume

import org.jetbrains.exposed.dao.LongEntityClass
import studio.hcmc.my_first_resume.exposed.entity.resume.ResumeMetadataEntity
import studio.hcmc.my_first_resume.exposed.table.resume.ResumeMetadataTable
import studio.hcmc.my_first_resume.module.dto.resume.ResumeNotFound
import studio.hcmc.my_first_resume.module.id.resume.ResumeId

object ResumeMetadataRepository : LongEntityClass<ResumeMetadataEntity>(
    ResumeMetadataTable,
    ResumeMetadataEntity::class.java
) {
    fun findById(id: ResumeId) : ResumeMetadataEntity {
        return findById(id.value) ?: throw ResumeNotFound
    }
}