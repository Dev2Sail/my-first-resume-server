package studio.hcmc.my_first_resume.exposed.entity.user

import kotlinx.datetime.Instant
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import studio.hcmc.my_first_resume.exposed.repository.user.UserMetadataRepository
import studio.hcmc.my_first_resume.exposed.repository.user.UserRepository.backReferencedOn
import studio.hcmc.my_first_resume.exposed.table.user.UserMetadataTable
import studio.hcmc.my_first_resume.exposed.table.user.UserTable
import studio.hcmc.my_first_resume.module.domain.user.UserDomain
import studio.hcmc.my_first_resume.module.domain.user.UserMetadataDomain
import studio.hcmc.my_first_resume.module.dto.user.UserDTO
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObjectConverter
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObjectConverter
import studio.hcmc.my_first_resume.module.vo.user.UserVO

class UserEntity(id: EntityID<Long>) :
    LongEntity(id),
    UserDomain.Verbose<EntityID<Long>>,
    ValueObjectConverter<UserVO>,
    VerboseValueObjectConverter<UserVO.Verbose>
{
    override var email by UserTable.email
    override var password by UserTable.password
    override var passwordSalt by UserTable.passwordSalt
    override var nickname by UserTable.nickname
    override val metadata by UserMetadataRepository.backReferencedOn(UserMetadataTable.id)
    override var createdAt by UserTable.createdAt
    override var lastModifiedAt by UserTable.lastModifiedAt

    override fun toValueObject() = UserVO(
        id = UserId(id.value),
        email = email,
        password = password,
        passwordSalt = passwordSalt,
        nickname = nickname,
        createdAt = createdAt,
        lastModifiedAt = lastModifiedAt
    )

    override fun toVerboseValueObject() = UserVO.Verbose(
        id = UserId(id.value),
        email = email,
        password = "Masked",
        passwordSalt = "Masked",
        nickname = nickname,
        metadata = metadata.toVerboseValueObject(),
        createdAt = createdAt,
        lastModifiedAt = lastModifiedAt
    )

    private fun fromDataTransferObject(dto: UserDTO, now: Instant) {
        when(dto) {
            is UserDTO.Post -> fromDateTransferObject(dto, now)
            is UserDTO.Put -> fromDateTransferObject(dto, now)
            is UserDTO.PatchNickname -> fromDateTransferObject(dto, now)
            is UserDTO.PatchPassword -> fromDateTransferObject(dto, now)
        }
    }

    private fun fromDateTransferObject(dto: UserDTO.Post, now: Instant) {
        this.email = dto.email
        this.password = dto.password
        this.passwordSalt = dto.passwordSalt
        this.nickname = dto.nickname
        this.createdAt = now
    }

    private fun fromDateTransferObject(dto: UserDTO.Put, now: Instant) {
        this.password = dto.password
        this.passwordSalt = dto.passwordSalt
        this.nickname = dto.nickname
        this.lastModifiedAt = now
    }

    private fun fromDateTransferObject(dto: UserDTO.PatchNickname, now: Instant) {
        this.nickname = dto.nickname
        this.lastModifiedAt = now
    }

    private fun fromDateTransferObject(dto: UserDTO.PatchPassword, now: Instant) {
        this.password = dto.password
        this.passwordSalt = dto.passwordSalt
        this.lastModifiedAt = now
    }
}