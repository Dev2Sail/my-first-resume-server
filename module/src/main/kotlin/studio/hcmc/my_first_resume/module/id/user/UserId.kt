package studio.hcmc.my_first_resume.module.id.user

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class UserId(val value: Long) {
    override fun toString(): String {
        return value.toString()
    }
}