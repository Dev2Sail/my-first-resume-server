package studio.hcmc.my_first_resume.module.util.hcmc_extension

interface VerboseValueObjectConverter<VVO : VerboseValueObject> {
    fun toVerboseValueObject(): VVO
}