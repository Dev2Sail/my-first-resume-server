package studio.hcmc.my_first_resume.module.dto.env

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.env.EnvApplicationVersionDomain
import studio.hcmc.my_first_resume.module.util.DataTransferObject

sealed interface EnvApplicationVersionDTO : DataTransferObject {
    @Serializable
    data class Post(
        val name: String,
        val platform: EnvApplicationVersionDomain.Platform,
        val distribution: EnvApplicationVersionDomain.Distribution,
        val expiredAt: Instant? = null
    ) : EnvApplicationVersionDTO

    @Serializable
    data class Put(
        val name: String,
        val expiredAt: Instant? = null
    ) : EnvApplicationVersionDTO
}