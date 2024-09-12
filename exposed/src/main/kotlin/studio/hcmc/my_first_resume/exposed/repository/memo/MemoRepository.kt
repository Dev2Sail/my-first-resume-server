package studio.hcmc.my_first_resume.exposed.repository.memo

import org.jetbrains.exposed.dao.LongEntityClass
import studio.hcmc.my_first_resume.exposed.entity.memo.MemoEntity
import studio.hcmc.my_first_resume.exposed.table.memo.MemoTable
import studio.hcmc.my_first_resume.module.dto.memo.MemoNotFound
import studio.hcmc.my_first_resume.module.id.memo.MemoId

object MemoRepository : LongEntityClass<MemoEntity>(
    MemoTable,
    MemoEntity::class.java
) {
    fun findById(id: MemoId) : MemoEntity {
        return findById(id.value) ?: throw MemoNotFound
    }
}