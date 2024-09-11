package studio.hcmc.my_first_resume.module.id.portfolio

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class PortfolioId(val value: Long) {
    override fun toString(): String {
        return value.toString()
    }
}
