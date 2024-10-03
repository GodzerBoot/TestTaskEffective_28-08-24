package com.example.testtaskeffective_29_08_24.di

import com.example.testtaskeffective_29_08_24.data.rasponse.ResponseApi
import com.example.testtaskeffective_29_08_24.data.rasponse.ResponseRepository
import com.example.testtaskeffective_29_08_24.domain.vacancies.GetMainScreenFullVacancyListUseCase
import com.example.testtaskeffective_29_08_24.domain.vacancies.GetMainScreenPartialResponseUseCase
import com.example.testtaskeffective_29_08_24.ui.main.MainViewModel
import com.example.testtaskeffective_29_08_24.ui.mainfull.MainFullViewModel
import com.github.terrakok.cicerone.Cicerone
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModules = module {
    factory<Gson> { configureGson() }
    single<Retrofit> { configureRetrofit() }
    single { get<Retrofit>().create(ResponseApi::class.java) }
    single { ResponseRepository(get()) }
    factory { GetMainScreenPartialResponseUseCase(get()) }
    factory { GetMainScreenFullVacancyListUseCase(get()) }
    viewModel { MainViewModel(get()) }
    viewModel { MainFullViewModel(get()) }
    single { Cicerone.create() }

}


private fun configureGson(): Gson {
    return GsonBuilder().create()
}

private fun configureRetrofit(): Retrofit {
    val baseUrl = "https://drive.usercontent.google.com/"
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}