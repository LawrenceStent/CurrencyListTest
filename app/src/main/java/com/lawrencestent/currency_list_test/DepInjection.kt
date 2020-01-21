package com.lawrencestent.currency_list_test

import android.app.Application
import android.content.Context
import org.kodein.di.Kodein
import org.kodein.di.generic.bind

fun depInjection(app: Application): Kodein {
    return Kodein.lazy {
        bind()
    }

}