package com.example.testtaskeffective_29_08_24.data.vacancy

import com.example.testtaskeffective_29_08_24.Offer
import com.example.testtaskeffective_29_08_24.Vacancy
import com.google.gson.annotations.SerializedName


data class VacancyResponce (

    @SerializedName("offers"    ) var offers    : ArrayList<Offer>    = arrayListOf(),
    @SerializedName("vacancies" ) var vacancies : ArrayList<Vacancy> = arrayListOf()

)