package studio.hcmc.my_first_resume.exposed.repository.portfolio

import org.jetbrains.exposed.dao.LongEntityClass
import studio.hcmc.my_first_resume.exposed.entity.portfolio.PortfolioSkillEntity
import studio.hcmc.my_first_resume.exposed.table.portfolio.PortfolioSkillTable
import studio.hcmc.my_first_resume.module.dto.portfolio.PortfolioSkillNotFound
import studio.hcmc.my_first_resume.module.id.portfolio.PortfolioSkillId

object PortfolioSkillRepository : LongEntityClass<PortfolioSkillEntity>(
    PortfolioSkillTable,
    PortfolioSkillEntity::class.java
) {
    fun findById(id: PortfolioSkillId) : PortfolioSkillEntity {
        return findById(id.value) ?: throw PortfolioSkillNotFound
    }
}