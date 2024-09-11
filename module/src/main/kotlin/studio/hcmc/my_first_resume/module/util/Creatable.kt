package studio.hcmc.my_first_resume.module.util

import kotlinx.datetime.Instant

interface Creatable {
    val createdAt: Instant
}