package studio.hcmc.my_first_resume.exposed.repository.portfolio

import org.jetbrains.exposed.dao.LongEntityClass
import studio.hcmc.my_first_resume.exposed.entity.portfolio.PortfolioLinkEntity
import studio.hcmc.my_first_resume.exposed.table.portfolio.PortfolioLinkTable
import studio.hcmc.my_first_resume.module.dto.portfolio.PortfolioLinkNotFound
import studio.hcmc.my_first_resume.module.id.portfolio.PortfolioLinkId

object PortfolioLinkRepository : LongEntityClass<PortfolioLinkEntity>(
    PortfolioLinkTable,
    PortfolioLinkEntity::class.java
) {
    fun findById(id: PortfolioLinkId) : PortfolioLinkEntity {
        return findById(id.value) ?: throw PortfolioLinkNotFound
    }
}