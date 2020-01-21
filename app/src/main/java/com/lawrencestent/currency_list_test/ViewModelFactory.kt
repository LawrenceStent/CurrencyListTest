package com.lawrencestent.currency_list_test

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ViewModelFactory private constructor(private val application: Application): ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(app: Application) =
            INSTANCE ?: synchronized(ViewModelFactory::class.java){
                INSTANCE ?: ViewModelFactory(app)
                    .also { INSTANCE = it }
            }
    }

    override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {
                isAssignableFrom(CurrencyViewModel::class.java) -> CurrencyViewModel(application)
                else ->  throw IllegalArgumentException("Unknown ViewModel Class: ${modelClass.name}")
            }
        } as T
    }
}