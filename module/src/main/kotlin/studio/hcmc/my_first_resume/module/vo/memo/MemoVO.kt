package studio.hcmc.my_first_resume.module.vo.memo

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.memo.Memo
import studio.hcmc.my_first_resume.module.domain.memo.MemoVerbose
import studio.hcmc.my_first_resume.module.id.memo.MemoId
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObject
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObject
import studio.hcmc.my_first_resume.module.vo.user.UserVO

@Serializable
data class MemoVO(
    override val id: MemoId,
    override val userId: UserId,
    override val body: String,
    override val createdAt: Instant,
    override val lastModifiedAt: Instant?,
    override val concealedAt: Instant?
) : ValueObject, Memo {
    @Serializable
    data class Verbose(
        override val id: MemoId,
        override val userId: UserId,
        override val user: UserVO.Verbose,
        override val body: String,
        override val createdAt: Instant,
        override val lastModifiedAt: Instant?,
        override val concealedAt: Instant?
    ) : VerboseValueObject, MemoVerbose
}
