package studio.hcmc.my_first_resume.module.vo.user

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import studio.hcmc.my_first_resume.module.domain.user.UserMetadata
import studio.hcmc.my_first_resume.module.domain.user.UserMetadataVerbose
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.ValueObject
import studio.hcmc.my_first_resume.module.util.VerboseValueObject

@Serializable
data class UserMetadataVO(
    override val id: UserId,
    override val resumeCount: Int,
    override val portfolioCount: Int,
    override val memoCount: Int,
    override val articleCount: Int,
    override val commentCount: Int,
    override val lastModifiedAt: Instant?
) : ValueObject, UserMetadata {
    @Serializable
    data class Verbose(
        override val id: UserId,
        override val resumeCount: Int,
        override val portfolioCount: Int,
        override val memoCount: Int,
        override val articleCount: Int,
        override val commentCount: Int,
        override val lastModifiedAt: Instant?
    ) : VerboseValueObject, UserMetadataVerbose
}
