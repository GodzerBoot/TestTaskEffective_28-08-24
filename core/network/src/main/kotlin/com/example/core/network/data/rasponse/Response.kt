package com.example.core.network.data.rasponse

import com.example.core.network.data.OfferResponse
import com.example.core.network.data.VacancyResponse
import com.google.gson.annotations.SerializedName


data class Response (

    @SerializedName("offers"    ) val offers    : ArrayList<OfferResponse>,
    @SerializedName("vacancies" ) val vacancies : ArrayList<VacancyResponse>,

    )