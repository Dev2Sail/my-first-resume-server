package studio.hcmc.my_first_resume.exposed.repository.env

import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.SqlExpressionBuilder.isNull
import org.jetbrains.exposed.sql.and
import studio.hcmc.my_first_resume.exposed.entity.env.EnvApplicationVersionEntity
import studio.hcmc.my_first_resume.exposed.table.env.EnvApplicationVersionTable
import studio.hcmc.my_first_resume.module.domain.env.EnvApplicationVersionDomain
import studio.hcmc.my_first_resume.module.dto.env.EnvApplicationVersionNotFound
import studio.hcmc.my_first_resume.module.id.env.EnvApplicationVersionId

object EnvApplicationVersionRepository : LongEntityClass<EnvApplicationVersionEntity>(
    EnvApplicationVersionTable,
    EnvApplicationVersionEntity::class.java
) {
    fun findById(id: EnvApplicationVersionId): EnvApplicationVersionEntity {
        return findById(id.value) ?: throw EnvApplicationVersionNotFound
    }

    fun findByProperties(
        versionName: String,
        platform: EnvApplicationVersionDomain.Platform,
        distribution: EnvApplicationVersionDomain.Distribution
    ): EnvApplicationVersionEntity {
        val op = EnvApplicationVersionTable.name.eq(versionName) and
                EnvApplicationVersionTable.platform.eq(platform) and
                EnvApplicationVersionTable.distribution.eq(distribution) and
                EnvApplicationVersionTable.expiredAt.isNull()
        return find(op)
            .limit(1)
            .firstOrNull()
            ?: throw EnvApplicationVersionNotFound
    }
}