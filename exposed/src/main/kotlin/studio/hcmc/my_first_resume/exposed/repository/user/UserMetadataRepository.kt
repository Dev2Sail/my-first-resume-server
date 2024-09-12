package studio.hcmc.my_first_resume.exposed.repository.user

import org.jetbrains.exposed.dao.LongEntityClass
import studio.hcmc.my_first_resume.exposed.entity.user.UserMetadataEntity
import studio.hcmc.my_first_resume.exposed.table.user.UserMetadataTable
import studio.hcmc.my_first_resume.module.dto.user.UserMetadataNotFound
import studio.hcmc.my_first_resume.module.id.user.UserId

object UserMetadataRepository : LongEntityClass<UserMetadataEntity>(
    UserMetadataTable,
    UserMetadataEntity::class.java
) {
    fun findById(id: UserId): UserMetadataEntity {
        return findById(id.value) ?: throw UserMetadataNotFound
    }
}