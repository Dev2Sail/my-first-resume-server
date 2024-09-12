package studio.hcmc.my_first_resume.exposed.repository.certificate

import org.jetbrains.exposed.dao.LongEntityClass
import studio.hcmc.my_first_resume.exposed.entity.certificate.CertificateEntity
import studio.hcmc.my_first_resume.exposed.table.certificate.CertificateTable
import studio.hcmc.my_first_resume.module.dto.certificate.CertificateNotFound
import studio.hcmc.my_first_resume.module.id.certificate.CertificateId

object CertificateRepository : LongEntityClass<CertificateEntity>(
    CertificateTable,
    CertificateEntity::class.java
) {
    fun findById(id: CertificateId) : CertificateEntity {
        return findById(id.value) ?: throw CertificateNotFound
    }
}