package com.example.core.network.data.rasponse


import retrofit2.http.GET


interface ResponseApi {
    @GET("u/0/uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r&export=download")
    suspend fun getVacancies() : Response

}