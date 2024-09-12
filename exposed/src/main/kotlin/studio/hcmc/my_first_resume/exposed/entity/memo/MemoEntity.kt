package studio.hcmc.my_first_resume.exposed.entity.memo

import kotlinx.datetime.Instant
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import studio.hcmc.my_first_resume.exposed.repository.user.UserRepository
import studio.hcmc.my_first_resume.exposed.table.memo.MemoTable
import studio.hcmc.my_first_resume.module.domain.memo.MemoDomain
import studio.hcmc.my_first_resume.module.dto.memo.MemoDTO
import studio.hcmc.my_first_resume.module.id.memo.MemoId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObjectConverter
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObjectConverter
import studio.hcmc.my_first_resume.module.vo.memo.MemoVO

class MemoEntity(id: EntityID<Long>) :
    LongEntity(id),
    MemoDomain.Verbose<EntityID<Long>, EntityID<Long>>,
    ValueObjectConverter<MemoVO>,
    VerboseValueObjectConverter<MemoVO.Verbose>
{
    override var userId by MemoTable.userId
    override val user by UserRepository referencedOn MemoTable.userId
    override var body by MemoTable.body
    override var createdAt by MemoTable.createdAt
    override var lastModifiedAt by MemoTable.lastModifiedAt
    override var concealedAt by MemoTable.concealedAt

    override fun toValueObject() = MemoVO(
        id = MemoId(id.value),
        userId = UserId(userId.value),
        body = body,
        createdAt = createdAt,
        lastModifiedAt = lastModifiedAt,
        concealedAt = concealedAt
    )

    override fun toVerboseValueObject() = MemoVO.Verbose(
        id = MemoId(id.value),
        userId = UserId(userId.value),
        user = user.toVerboseValueObject(),
        body = body,
        createdAt = createdAt,
        lastModifiedAt = lastModifiedAt,
        concealedAt = concealedAt
    )

    fun fromDataTransferObject(dto: MemoDTO, now: Instant) {
        when(dto) {
            is MemoDTO.Post -> fromDataTransferObject(dto, now)
            is MemoDTO.Put -> fromDataTransferObject(dto, now)
        }
    }

    private fun fromDataTransferObject(dto: MemoDTO.Post, now: Instant) {
        this.body = dto.body
        this.createdAt = now
    }

    private fun fromDataTransferObject(dto: MemoDTO.Put, now: Instant) {
        this.body = dto.body
        this.lastModifiedAt = now
    }
}