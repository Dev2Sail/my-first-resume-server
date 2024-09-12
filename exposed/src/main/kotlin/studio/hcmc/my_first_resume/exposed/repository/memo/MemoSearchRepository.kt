package studio.hcmc.my_first_resume.exposed.repository.memo

import org.jetbrains.exposed.dao.LongEntityClass
import studio.hcmc.my_first_resume.exposed.entity.memo.MemoSearchEntity
import studio.hcmc.my_first_resume.exposed.table.memo.MemoSearchTable
import studio.hcmc.my_first_resume.module.dto.memo.MemoNotFound
import studio.hcmc.my_first_resume.module.id.memo.MemoSearchId

object MemoSearchRepository : LongEntityClass<MemoSearchEntity>(
    MemoSearchTable,
    MemoSearchEntity::class.java
) {
    fun findById(id: MemoSearchId) : MemoSearchEntity {
        return findById(id.value) ?: throw MemoNotFound
    }
}