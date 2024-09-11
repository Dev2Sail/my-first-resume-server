package studio.hcmc.my_first_resume.module.id.memo

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class MemoSearchId(val value: Long) {
    override fun toString(): String {
        return value.toString()
    }
}