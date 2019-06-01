package com.example.myassistant.finance

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myassistant.R

class FinanceCardHeader(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    init {
        inflate(context, R.layout.finance_header, this)
        obtainStyleAttributes(context, attrs)
    }

    private fun obtainStyleAttributes(context: Context, attrs: AttributeSet) {

    }

}