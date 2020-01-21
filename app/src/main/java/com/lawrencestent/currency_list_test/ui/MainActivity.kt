package com.lawrencestent.currency_list_test.ui

import android.os.Bundle
import android.widget.Toolbar
import com.lawrencestent.currency_list_test.CurrencyViewModel
import com.lawrencestent.currency_list_test.R

class MainActivity: BaseActivity() {

    private var currencyViewModel: CurrencyViewModel? = null

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        currencyViewModel = obtainViewModel(CurrencyViewModel::class.java)

        setUpViews()

    }

    private fun setUpViews() {
        toolbar = findViewById(R.id.main_toolbar)
        toolbar.title = getString(R.string.title_rates)
    }



}