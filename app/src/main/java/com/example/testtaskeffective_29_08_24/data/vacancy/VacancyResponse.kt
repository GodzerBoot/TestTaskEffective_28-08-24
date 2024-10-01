package com.example.testtaskeffective_29_08_24.data.vacancy

import com.example.testtaskeffective_29_08_24.OfferResponse
import com.example.testtaskeffective_29_08_24.VacancyResponse
import com.google.gson.annotations.SerializedName


data class VacancyResponse (

    @SerializedName("offers"    ) var offers    : ArrayList<OfferResponse>    = arrayListOf(),
    @SerializedName("vacancies" ) var vacancies : ArrayList<VacancyResponse> = arrayListOf()

)