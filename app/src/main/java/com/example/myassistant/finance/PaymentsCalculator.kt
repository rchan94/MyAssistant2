package com.example.myassistant.finance


class PaymentsCalculator {

    fun getTotalRemaining(remainingPayments: List<Payment>) = remainingPayments.sumByDouble { it.amount }

}
