package com.example.testtaskeffective_29_08_24.di

import com.example.testtaskeffective_29_08_24.data.vacancy.VacancyRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { VacancyRepository(get()) }
}