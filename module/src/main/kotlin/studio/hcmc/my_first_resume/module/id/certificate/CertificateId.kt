package studio.hcmc.my_first_resume.module.id.certificate

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class CertificateId(val value: Long) {
    override fun toString(): String {
        return value.toString()
    }
}