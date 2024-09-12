package studio.hcmc.my_first_resume.module.dto.memo

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.DataTransferObject

sealed interface MemoSearchDTO : DataTransferObject {
    @Serializable
    data class Post(
        val body: String
    ) : MemoSearchDTO
}