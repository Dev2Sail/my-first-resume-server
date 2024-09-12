package studio.hcmc.my_first_resume.exposed.entity.user

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import studio.hcmc.my_first_resume.exposed.table.user.UserMetadataTable
import studio.hcmc.my_first_resume.module.domain.user.UserMetadataDomain
import studio.hcmc.my_first_resume.module.id.user.UserId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObjectConverter
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObjectConverter
import studio.hcmc.my_first_resume.module.vo.user.UserMetadataVO

class UserMetadataEntity(id: EntityID<Long>) :
    LongEntity(id),
    UserMetadataDomain.Verbose<EntityID<Long>>,
    ValueObjectConverter<UserMetadataVO>,
    VerboseValueObjectConverter<UserMetadataVO.Verbose>
{
    override var resumeCount by UserMetadataTable.resumeCount
    override var portfolioCount by UserMetadataTable.portfolioCount
    override var memoCount by UserMetadataTable.memoCount
    override var articleCount by UserMetadataTable.articleCount
    override var commentCount by UserMetadataTable.commentCount
    override var lastModifiedAt by UserMetadataTable.lastModifiedAt

    override fun toValueObject() = UserMetadataVO(
        id = UserId(id.value),
        resumeCount = resumeCount,
        portfolioCount = portfolioCount,
        memoCount = memoCount,
        articleCount = articleCount,
        commentCount = commentCount,
        lastModifiedAt = lastModifiedAt
    )

    override fun toVerboseValueObject() = UserMetadataVO.Verbose(
        UserId(id.value),
        resumeCount = resumeCount,
        portfolioCount = portfolioCount,
        memoCount = memoCount,
        articleCount = articleCount,
        commentCount = commentCount,
        lastModifiedAt = lastModifiedAt
    )
}