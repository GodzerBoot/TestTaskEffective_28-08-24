package com.example.testtaskeffective_29_08_24.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val commonNetworkModule = module {
    factory<Gson> { configureGson() }
    single<Retrofit> { configureRetrofit() }
}


private fun configureGson(): Gson {
    return GsonBuilder().create()
}

private fun configureRetrofit(): Retrofit {
    val BASE_URL = "https://drive.usercontent.google.com/"
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}