package com.example.features.main_screen.domain

import com.example.core.network.data.OfferButton


data class Offer(
    val type: OfferType,
    val title: String,
    val button: OfferButton?,
    val link: String,
) {
    enum class OfferType(val value: String?){
        NEAR_VACANCIES("near_vacancies"),
        LEVEL_UP_RESUME("level_up_resume"),
        TEMPORARY_JOB("temporary_job"),
        UNDEFINED(null);
        companion object {
            fun parse(value: String?): OfferType{
                return when(value){
                    NEAR_VACANCIES.value -> NEAR_VACANCIES
                    LEVEL_UP_RESUME.value -> LEVEL_UP_RESUME
                    TEMPORARY_JOB.value -> TEMPORARY_JOB
                    else -> UNDEFINED
                }
            }
        }
    }
}
