package com.example.testtaskeffective_29_08_24.di

import com.example.testtaskeffective_29_08_24.ui.main.MainViewModel
import com.example.testtaskeffective_29_08_24.ui.mainfull.MainFullViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { MainFullViewModel(get()) }
}