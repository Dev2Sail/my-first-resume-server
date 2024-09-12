package studio.hcmc.my_first_resume.exposed.repository.portfolio

import org.jetbrains.exposed.dao.LongEntityClass
import studio.hcmc.my_first_resume.exposed.entity.portfolio.PortfolioEntity
import studio.hcmc.my_first_resume.exposed.table.portfolio.PortfolioTable
import studio.hcmc.my_first_resume.module.dto.portfolio.PortfolioNotFound
import studio.hcmc.my_first_resume.module.id.portfolio.PortfolioId

object PortfolioRepository : LongEntityClass<PortfolioEntity>(
    PortfolioTable,
    PortfolioEntity::class.java
) {
    fun findById(id: PortfolioId) : PortfolioEntity {
        return findById(id.value) ?: throw PortfolioNotFound
    }
}