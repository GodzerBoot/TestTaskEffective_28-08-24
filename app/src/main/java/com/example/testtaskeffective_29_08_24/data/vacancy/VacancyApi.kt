package com.example.testtaskeffective_29_08_24.data.vacancy


import com.example.testtaskeffective_29_08_24.data.vacancy.VacancyResponce
import retrofit2.http.GET


interface VacancyApi {
    @GET("u/0/uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r&export=download")
    suspend fun getVacancies() : VacancyResponce

}