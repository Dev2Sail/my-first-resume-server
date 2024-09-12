package studio.hcmc.my_first_resume.module.util.hcmc_extension

interface ValueObjectConverter<VO: ValueObject> {
    fun toValueObject(): VO
}

fun <VO: ValueObject, VOC : ValueObjectConverter<VO>> Iterable<VOC>.toValueObjects(): List<VO> {
    return map { it.toValueObject() }
}