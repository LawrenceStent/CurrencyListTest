package com.lawrencestent.currency_list_test

import android.content.Context
import com.lawrencestent.currency_list_test.model.CurrencyPriceData
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class CurrencyApiService(val context: Context) {

    private val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        })
        .build()


    private val retrofit: Retrofit
        get() {
            return Retrofit.Builder()
                .baseUrl(context.resources.getString(R.string.revolut_api_endpoint))
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        }

    private val currencyApi: CurrencyApi
        get() {
            return retrofit.create(CurrencyApi::class.java)
        }

    fun getCurrencyPriceListData(baseCurrencyShort: String): Observable<CurrencyPriceData> {
        return currencyApi.getCurrencyPrices(baseCurrencyShort)
    }
}