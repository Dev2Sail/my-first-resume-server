package studio.hcmc.my_first_resume.exposed.entity.memo

import kotlinx.datetime.Instant
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import studio.hcmc.my_first_resume.exposed.repository.user.UserRepository
import studio.hcmc.my_first_resume.exposed.table.memo.MemoSearchTable
import studio.hcmc.my_first_resume.module.domain.memo.MemoSearchDomain
import studio.hcmc.my_first_resume.module.dto.memo.MemoSearchDTO
import studio.hcmc.my_first_resume.module.id.memo.MemoSearchId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObjectConverter
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObjectConverter
import studio.hcmc.my_first_resume.module.vo.memo.MemoSearchVO

class MemoSearchEntity(id: EntityID<Long>) :
    LongEntity(id),
    MemoSearchDomain.Verbose<EntityID<Long>, EntityID<Long>>,
    ValueObjectConverter<MemoSearchVO>,
    VerboseValueObjectConverter<MemoSearchVO.Verbose>
{
    override var userId by MemoSearchTable.userId
    override val user by UserRepository referencedOn MemoSearchTable.userId
    override var body by MemoSearchTable.body
    override var createdAt by MemoSearchTable.createdAt

    override fun toValueObject() = MemoSearchVO(
        id = MemoSearchId(id.value),
        userId = UserId(userId.value),
        body = body,
        createdAt = createdAt
    )

    override fun toVerboseValueObject() = MemoSearchVO.Verbose(
        id = MemoSearchId(id.value),
        userId = UserId(userId.value),
        user = user.toVerboseValueObject(),
        body = body,
        createdAt = createdAt
    )

    fun fromDataTransferObject(dto: MemoSearchDTO, now: Instant) {
        when(dto) {
            is MemoSearchDTO.Post -> fromDataTransferObject(dto, now)
        }
    }

    private fun fromDataTransferObject(dto: MemoSearchDTO.Post, now: Instant) {
        this.body = dto.body
        this.createdAt = now
    }
}