package com.lawrencestent.currency_list_test.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.lawrencestent.currency_list_test.R
import kotlinx.android.synthetic.main.holder_currency_item.view.*

class CurrencyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    companion object {
        private fun createView(parentView: ViewGroup): View {
            return LayoutInflater.from(parentView.context).inflate(
                R.layout.holder_currency_item, parentView, false)
        }

        fun newInstance(parentView: ViewGroup): CurrencyViewHolder {
            return CurrencyViewHolder(
                createView(
                    parentView
                )
            )
        }
    }

    val currencyHolderRootLayout: ConstraintLayout by lazy {
        itemView.currency_item_root
    }

    fun updateCurrencyPrice(){

    }
}