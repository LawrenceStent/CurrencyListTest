package com.lawrencestent.currency_list_test.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.lawrencestent.currency_list_test.ViewModelFactory

abstract class BaseActivity: AppCompatActivity() {

    fun <T : ViewModel> obtainViewModel(viewModelClass: Class<T>) =
        ViewModelProviders.of(this,
            ViewModelFactory.getInstance(
                application
            )
        ).get(viewModelClass)

}