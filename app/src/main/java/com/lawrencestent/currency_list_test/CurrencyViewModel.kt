package com.lawrencestent.currency_list_test

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.kodein.di.generic.instance
import timber.log.Timber

class CurrencyViewModel(application: Application): AndroidViewModel(application) {


    private val currencyRepository: CurrencyRepository by App.kodein.instance()

    private var rxSubs : CompositeDisposable? = null

    init {
        rxSubs = CompositeDisposable()
    }

    fun getCurrencyPriceListData(baseCurrency: String){
        rxSubs?.add(currencyRepository.getCurrencyPriceListData(baseCurrency)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                Timber.d("Fetch price data success")
            },{

            }
        ))
    }


    override fun onCleared() {
        rxSubs?.clear()
        super.onCleared()
    }
}