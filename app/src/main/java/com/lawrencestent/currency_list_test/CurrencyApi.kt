package com.lawrencestent.currency_list_test

import com.lawrencestent.currency_list_test.model.CurrencyPriceData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {

    @GET("latest?")
    fun getCurrencyPrices(@Query("base") base: String) : Observable<CurrencyPriceData>
}