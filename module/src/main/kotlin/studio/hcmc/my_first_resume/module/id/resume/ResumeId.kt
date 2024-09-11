package studio.hcmc.my_first_resume.module.id.resume

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class ResumeId(val value: Long) {
    override fun toString(): String {
        return value.toString()
    }
}