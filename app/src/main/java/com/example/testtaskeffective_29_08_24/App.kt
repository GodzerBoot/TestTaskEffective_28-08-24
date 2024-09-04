package com.example.testtaskeffective_29_08_24

import android.app.Application
import com.example.testtaskeffective_29_08_24.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModules)
        }
    }
}