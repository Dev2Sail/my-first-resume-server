package studio.hcmc.my_first_resume.exposed.repository.user

import org.jetbrains.exposed.dao.LongEntityClass
import studio.hcmc.my_first_resume.exposed.entity.user.UserSignInEntity
import studio.hcmc.my_first_resume.exposed.table.user.UserSignInTable
import studio.hcmc.my_first_resume.module.dto.user.UserNotAuthorized
import studio.hcmc.my_first_resume.module.id.user.UserSignInId

object UserSignInRepository : LongEntityClass<UserSignInEntity>(
    UserSignInTable,
    UserSignInEntity::class.java
) {
    fun findById(id: UserSignInId) : UserSignInEntity {
        return findById(id.value) ?: throw UserNotAuthorized
    }
}