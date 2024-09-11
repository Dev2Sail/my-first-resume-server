package studio.hcmc.my_first_resume.module.id.env

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class EnvApplicationVersionId(val value: Long) {
    override fun toString(): String {
        return value.toString()
    }
}