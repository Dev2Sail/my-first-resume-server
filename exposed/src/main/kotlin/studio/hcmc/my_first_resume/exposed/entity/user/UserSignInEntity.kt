package studio.hcmc.my_first_resume.exposed.entity.user

import kotlinx.datetime.Instant
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import studio.hcmc.my_first_resume.exposed.repository.env.EnvApplicationVersionRepository
import studio.hcmc.my_first_resume.exposed.repository.user.UserRepository
import studio.hcmc.my_first_resume.exposed.table.user.UserSignInTable
import studio.hcmc.my_first_resume.module.domain.user.UserSignInDomain
import studio.hcmc.my_first_resume.module.dto.user.UserSignInDTO
import studio.hcmc.my_first_resume.module.id.env.EnvApplicationVersionId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.id.user.UserSignInId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObjectConverter
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObjectConverter
import studio.hcmc.my_first_resume.module.vo.user.UserSIgnInVO

class UserSignInEntity(id: EntityID<Long>) :
    LongEntity(id),
    UserSignInDomain.Verbose<EntityID<Long>, EntityID<Long>, EntityID<Long>>,
    ValueObjectConverter<UserSIgnInVO>,
    VerboseValueObjectConverter<UserSIgnInVO.Verbose>
{
    override var userId by UserSignInTable.userId
    override val user by UserRepository referencedOn UserSignInTable.userId
    override var remoteAddress by UserSignInTable.remoteAddress
    override var envApplicationVersionId by UserSignInTable.envApplicationVersionId
    override val envApplicationVersion by EnvApplicationVersionRepository referencedOn UserSignInTable.envApplicationVersionId
    override var deviceName by UserSignInTable.deviceName
    override var deviceVersion by UserSignInTable.deviceVersion
    override var createdAt by UserSignInTable.createdAt

    override fun toValueObject() = UserSIgnInVO(
        id = UserSignInId(id.value),
        userId = UserId(userId.value),
        remoteAddress = remoteAddress,
        envApplicationVersionId = EnvApplicationVersionId(envApplicationVersionId.value),
        deviceName = deviceName,
        deviceVersion = deviceVersion,
        createdAt = createdAt
    )

    override fun toVerboseValueObject() = UserSIgnInVO.Verbose(
        id = UserSignInId(id.value),
        userId = UserId(userId.value),
        user = user.toVerboseValueObject(),
        remoteAddress = remoteAddress,
        envApplicationVersionId = EnvApplicationVersionId(envApplicationVersionId.value),
        envApplicationVersion = envApplicationVersion.toVerboseValueObject(),
        deviceName = deviceName,
        deviceVersion = deviceVersion,
        createdAt = createdAt
    )

    fun fromDataTransferObject(dto: UserSignInDTO, now: Instant) {
        when(dto) {
            is UserSignInDTO.Post -> fromDataTransferObject(dto, now)
        }
    }

    private fun fromDataTransferObject(dto: UserSignInDTO.Post, now: Instant) {
        this.deviceName = dto.deviceName
        this.deviceVersion = dto.deviceVersion
        this.createdAt = now
    }
}