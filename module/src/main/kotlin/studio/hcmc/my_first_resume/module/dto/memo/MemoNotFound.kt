package studio.hcmc.my_first_resume.module.dto.memo

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.ErrorDataTransferObject

@Serializable
data object MemoNotFound : ErrorDataTransferObject() {
    override val httpStatusCode = 404
    private fun readResolve(): Any = MemoNotFound
}