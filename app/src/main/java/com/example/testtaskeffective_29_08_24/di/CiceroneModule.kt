package com.example.testtaskeffective_29_08_24.di

import com.github.terrakok.cicerone.Cicerone
import org.koin.dsl.module

val ciceroneModule = module {
    single { Cicerone.create() }
}