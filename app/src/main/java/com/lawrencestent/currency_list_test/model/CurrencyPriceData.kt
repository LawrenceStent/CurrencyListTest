package com.lawrencestent.currency_list_test.model

data class CurrencyPriceData(val base: String,
                             val date: String,
                             val rates: List<CurrencyData>) {
}