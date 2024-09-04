package com.example.testtaskeffective_29_08_24.di

import com.example.testtaskeffective_29_08_24.data.vacancy.VacancyApi
import com.example.testtaskeffective_29_08_24.data.vacancy.VacancyRepository
import com.example.testtaskeffective_29_08_24.ui.main.MainViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModules = module {
    factory<Gson> { configureGson() }
    single<Retrofit> { configureRetrofit() }
    single { get<Retrofit>().create(VacancyApi::class.java) }
    single { VacancyRepository(get()) }
    viewModel { MainViewModel(get()) }

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