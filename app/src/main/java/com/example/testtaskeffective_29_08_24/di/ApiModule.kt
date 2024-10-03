package com.example.testtaskeffective_29_08_24.di

import com.example.testtaskeffective_29_08_24.data.rasponse.ResponseApi
import org.koin.dsl.module
import retrofit2.Retrofit

val commonApiModule = module {
    single { get<Retrofit>().create(ResponseApi::class.java) }
}
