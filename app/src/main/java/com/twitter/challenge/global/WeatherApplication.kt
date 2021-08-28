package com.twitter.challenge.global

import android.app.Application
import com.twitter.challenge.modules.networkModule
import com.twitter.challenge.modules.repositoryModule
import com.twitter.challenge.modules.viewModelModule
import org.koin.core.context.startKoin

class WeatherApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        //Start koin modules
        startKoin {
            modules(networkModule, repositoryModule, viewModelModule)
        }
    }
}