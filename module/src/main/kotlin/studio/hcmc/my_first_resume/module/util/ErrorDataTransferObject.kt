package studio.hcmc.my_first_resume.module.util

import kotlinx.serialization.Serializable

@Serializable
abstract class ErrorDataTransferObject : Throwable, DataTransferObject {
    abstract val httpStatusCode: Int

    constructor() : super()

    constructor(cause: Throwable?) : super(cause)

    constructor(message: String?) : super(message)

    constructor(message: String?, cause: Throwable?) : super(message, cause)
}