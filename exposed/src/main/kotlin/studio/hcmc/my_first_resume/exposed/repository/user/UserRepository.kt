package studio.hcmc.my_first_resume.exposed.repository.user

import org.jetbrains.exposed.dao.LongEntityClass
import studio.hcmc.my_first_resume.exposed.entity.user.UserEntity
import studio.hcmc.my_first_resume.exposed.table.user.UserTable
import studio.hcmc.my_first_resume.module.dto.user.UserNotFound
import studio.hcmc.my_first_resume.module.id.user.UserId

object UserRepository : LongEntityClass<UserEntity>(
    UserTable,
    UserEntity::class.java
) {
    fun findById(id: UserId): UserEntity {
        return findById(id.value) ?: throw UserNotFound
    }
}