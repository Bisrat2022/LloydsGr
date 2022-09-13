package com.lloydsbankinggroupcc.ui

import android.app.Application
import com.lloydsbankinggroupcc.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PetsApplication : Application() {

    companion object {
        lateinit var instance: Application
        fun getAppContext() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@PetsApplication)
            modules(petsDataBaseModule, apiModule, repositoryModule, networkModule, viewModelModule)
        }
    }


}