package com.example.testtaskeffective_29_08_24.di

import android.content.Context
import androidx.room.Room
import com.example.core.navigation.Screens
import com.example.core.network.data.rasponse.ResponseApi
import com.example.core.network.data.rasponse.ResponseRepository
import com.example.features.local_database.AppDatabase
import com.example.features.main_screen.domain.GetMainScreenResponseUseCase
import com.example.features.main_screen.ui.MainScreenViewModel
import com.example.testtaskeffective_29_08_24.domain.vacancies.GetMainScreenFullVacancyListUseCase
import com.example.testtaskeffective_29_08_24.ui.ScreensImpl
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
    factory { GetMainScreenResponseUseCase(get()) }
    factory { GetMainScreenFullVacancyListUseCase(get()) }
    viewModel { MainScreenViewModel(get()) }
    single { Cicerone.create() }
    single<Screens> { ScreensImpl() }
    single { buildDatabase(get()) }
    single { get<AppDatabase>().vacancyDao() }
}


private fun buildDatabase(applicationContext: Context): AppDatabase {
    return Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "favourite-vacancies-database"
    ).build()
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