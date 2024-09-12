package studio.hcmc.my_first_resume.module.util.hcmc_extension

import kotlinx.datetime.Instant

interface Modifiable {
    val lastModifiedAt: Instant?

    val isModified: Boolean get() = lastModifiedAt != null
}