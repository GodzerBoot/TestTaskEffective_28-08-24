package com.example.testtaskeffective_29_08_24

import android.app.Application
import com.example.testtaskeffective_29_08_24.di.appModules
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    private val cicerone : Cicerone<Router> by inject()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        startKoin {
            androidContext(this@App)
            modules(appModules)
        }
    }

    companion object {
        internal lateinit var INSTANCE: App // "internal" - ?
            private set
    }
}