package studio.hcmc.my_first_resume.module.dto.user

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.ErrorDataTransferObject

@Serializable
data object UserMetadataNotFound: ErrorDataTransferObject() {
    override val httpStatusCode = 404
    private fun readResolve(): Any = UserMetadataNotFound
}