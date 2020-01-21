package com.lawrencestent.currency_list_test

import android.app.Application
import android.content.Context
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class App: Application() {

    companion object {
        lateinit var kodein: Kodein
    }


    override fun onCreate() {
        super.onCreate()

        kodein = Kodein {
            bind<Context>() with instance(applicationContext)
            bind<CurrencyApiService>() with singleton { CurrencyApiService(instance()) }
            bind<CurrencyRepository>() with provider {
                val remoteDataSource = CurrencyRemoteDataSource(instance())
                val repository = CurrencyRepository(remoteDataSource)
                repository
            }
        }

    }
}