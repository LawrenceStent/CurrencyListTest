package com.lawrencestent.currency_list_test

import com.lawrencestent.currency_list_test.model.CurrencyPriceData
import io.reactivex.Observable

class CurrencyRepository(private val currencyRemoteDataSource: CurrencyRemoteDataSource) {


    fun getCurrencyPriceListData(baseCurrency: String): Observable<CurrencyPriceData> {
        return currencyRemoteDataSource.getCurrencyPriceListData(baseCurrency)
    }
}