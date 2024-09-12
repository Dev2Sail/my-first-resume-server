package studio.hcmc.my_first_resume.module.dto.user

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ErrorDataTransferObject

@Serializable
data object UserNotAuthorized : ErrorDataTransferObject() {
    override val httpStatusCode = 401
    private fun readResolve(): Any = UserNotAuthorized
}