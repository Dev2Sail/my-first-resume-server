package studio.hcmc.my_first_resume.module.dto.certificate

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ErrorDataTransferObject

@Serializable
data object CertificateNotFound : ErrorDataTransferObject() {
    override val httpStatusCode = 404
    private fun readResolve(): Any = CertificateNotFound
}