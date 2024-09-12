package studio.hcmc.my_first_resume.module.dto.article

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ErrorDataTransferObject

@Serializable
data object ArticleNotFound : ErrorDataTransferObject() {
    override val httpStatusCode = 404
    private fun readResolve(): Any = ArticleNotFound
}