package studio.hcmc.my_first_resume.exposed.entity.resume

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import studio.hcmc.my_first_resume.exposed.table.resume.ResumeMetadataTable
import studio.hcmc.my_first_resume.module.domain.resume.ResumeMetadataDomain
import studio.hcmc.my_first_resume.module.id.resume.ResumeId
import studio.hcmc.my_first_resume.module.util.hcmc_extension.ValueObjectConverter
import studio.hcmc.my_first_resume.module.util.hcmc_extension.VerboseValueObjectConverter
import studio.hcmc.my_first_resume.module.vo.resume.ResumeMetadataVO

class ResumeMetadataEntity(id: EntityID<Long>) :
    LongEntity(id),
    ResumeMetadataDomain.Verbose<EntityID<Long>>,
    ValueObjectConverter<ResumeMetadataVO>,
    VerboseValueObjectConverter<ResumeMetadataVO.Verbose>
{
    override var subjectCount by ResumeMetadataTable.subjectCount
    override var isFinishCount by ResumeMetadataTable.isFinishCount
    override var lastModifiedAt by ResumeMetadataTable.lastModifiedAt

    override fun toValueObject() = ResumeMetadataVO(
        id = ResumeId(id.value),
        subjectCount = subjectCount,
        isFinishCount = isFinishCount,
        lastModifiedAt = lastModifiedAt
    )

    override fun toVerboseValueObject() = ResumeMetadataVO.Verbose(
        id = ResumeId(id.value),
        subjectCount = subjectCount,
        isFinishCount = isFinishCount,
        lastModifiedAt = lastModifiedAt
    )
}