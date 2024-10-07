package com.example.core.network.data.rasponse

import com.example.testtaskeffective_29_08_24.OfferResponse
import com.example.testtaskeffective_29_08_24.VacancyResponse
import com.google.gson.annotations.SerializedName


data class Response (

    @SerializedName("offers"    ) val offers    : ArrayList<OfferResponse>,
    @SerializedName("vacancies" ) val vacancies : ArrayList<VacancyResponse>,

)