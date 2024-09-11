package studio.hcmc.my_first_resume.module.util

import kotlinx.datetime.Instant

interface Concealable : Creatable {
    override val createdAt: Instant
    val concealedAt: Instant?

    val isConcealed: Boolean get() = concealedAt != null
}