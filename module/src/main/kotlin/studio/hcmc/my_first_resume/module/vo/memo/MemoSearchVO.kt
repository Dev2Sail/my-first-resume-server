package studio.hcmc.my_first_resume.module.vo.memo

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.memo.MemoSearch
import studio.hcmc.my_first_resume.module.domain.memo.MemoSearchVerbose
import studio.hcmc.my_first_resume.module.id.memo.MemoSearchId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObject
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObject
import studio.hcmc.my_first_resume.module.vo.user.UserVO

@Serializable
data class MemoSearchVO(
    override val id: MemoSearchId,
    override val userId: UserId,
    override val body: String,
    override val createdAt: Instant
) : ValueObject, MemoSearch {
    @Serializable
    data class Verbose(
        override val id: MemoSearchId,
        override val userId: UserId,
        override val user: UserVO.Verbose,
        override val body: String,
        override val createdAt: Instant
    ) : VerboseValueObject, MemoSearchVerbose
}
