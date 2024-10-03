package com.example.testtaskeffective_29_08_24.di

import com.example.testtaskeffective_29_08_24.data.rasponse.ResponseRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { ResponseRepository(get()) }
}