package com.lawrencestent.currency_list_test

import com.lawrencestent.currency_list_test.model.CurrencyPriceData
import io.reactivex.Observable

class CurrencyRemoteDataSource(private val currencyApiService: CurrencyApiService) {

    fun getCurrencyPriceListData(baseCurrencyShort: String): Observable<CurrencyPriceData> {
        return currencyApiService.getCurrencyPriceListData(baseCurrencyShort)
    }
}