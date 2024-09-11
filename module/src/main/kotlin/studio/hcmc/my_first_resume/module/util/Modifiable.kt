package studio.hcmc.my_first_resume.module.util

import kotlinx.datetime.Instant

interface Modifiable {
    val lastModifiedAt: Instant?

    val isModified: Boolean get() = lastModifiedAt != null
}