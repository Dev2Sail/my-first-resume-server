package studio.hcmc.my_first_resume.module.vo.env

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.env.EnvApplicationVersion
import studio.hcmc.my_first_resume.module.domain.env.EnvApplicationVersionDomain
import studio.hcmc.my_first_resume.module.domain.env.EnvApplicationVersionVerbose
import studio.hcmc.my_first_resume.module.domain.user.UserDomain
import studio.hcmc.my_first_resume.module.id.env.EnvApplicationVersionId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObject
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObject

@Serializable
data class EnvApplicationVersionVO(
    override val id: EnvApplicationVersionId,
    override val creatorId: UserId,
    override val name: String,
    override val platform: EnvApplicationVersionDomain.Platform,
    override val distribution: EnvApplicationVersionDomain.Distribution,
    override val expiredAt: Instant?,
    override val createdAt: Instant,
    override val lastModifiedAt: Instant?
) : ValueObject, EnvApplicationVersion {
    @Serializable
    data class Verbose(
        override val id: EnvApplicationVersionId,
        override val creatorId: UserId,
        override val creator: UserDomain.Verbose<UserId>,
        override val name: String,
        override val platform: EnvApplicationVersionDomain.Platform,
        override val distribution: EnvApplicationVersionDomain.Distribution,
        override val expiredAt: Instant?,
        override val createdAt: Instant,
        override val lastModifiedAt: Instant?
    ) : VerboseValueObject, EnvApplicationVersionVerbose
}