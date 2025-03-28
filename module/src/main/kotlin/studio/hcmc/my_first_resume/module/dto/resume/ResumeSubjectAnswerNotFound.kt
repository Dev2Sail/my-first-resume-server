package studio.hcmc.my_first_resume.module.dto.resume

import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.util.ErrorDataTransferObject

@Serializable
data object ResumeSubjectAnswerNotFound : ErrorDataTransferObject() {
    override val httpStatusCode = 404
    private fun readResolve(): Any = ResumeSubjectAnswerNotFound
}