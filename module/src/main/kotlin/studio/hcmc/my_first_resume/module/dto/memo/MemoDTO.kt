package studio.hcmc.my_first_resume.module.dto.memo

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.DataTransferObject

sealed interface MemoDTO : DataTransferObject {
    @Serializable
    data class Post(
        val body: String
    ) : MemoDTO

    @Serializable
    data class Put(
        val body: String
    ) : MemoDTO
}