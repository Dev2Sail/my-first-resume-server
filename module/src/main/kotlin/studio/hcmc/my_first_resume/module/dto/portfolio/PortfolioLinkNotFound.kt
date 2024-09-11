package studio.hcmc.my_first_resume.module.dto.portfolio

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.ErrorDataTransferObject

@Serializable
data object PortfolioLinkNotFound : ErrorDataTransferObject() {
    override val httpStatusCode = 404
    private fun readResolve(): Any = PortfolioLinkNotFound
}