package com.example.myassistant.useCase

import com.example.myassistant.finance.Payment
import com.example.myassistant.finance.PaymentsCalculator
import com.example.myassistant.finance.Type
import java.util.*

class GetPaymentsUseCase {

    fun getPayments(): List<Payment> {
        return listOf(
            Payment(11, 400.00, description = "Savings", type = Type.MONEY),
            Payment(11, 95.48, description = "Car Insurance", type = Type.CAR),
            Payment(13, 60.00, description = "Piano", type = Type.MUSIC),
            Payment(15, 28.00, description = "Car Service", type = Type.CAR),
            Payment(15, 15.00, description = "Phone Top-up", type = Type.PHONE),
            Payment(18, 9.99, description = "Spotify", type = Type.MUSIC),
            Payment(18, 9.99, description = "Gym", type = Type.SPORTS),
            Payment(20, 200.00, true, description = "Tandem Payment", type = Type.MONEY),
            Payment(25, 9.99, description = "Netflix", type = Type.TV),
            Payment(27, 295.24, description = "Car Payment", type = Type.CAR)
        )
    }

    fun getCurrentDayOfMonth(): Int {
        val cal = Calendar.getInstance()
        cal.time = Date()
        return cal.get(Calendar.DAY_OF_MONTH)
    }

    private fun getUpcomingPaymentsList(): List<Payment> {
        return getPayments().filter { it.day > getCurrentDayOfMonth() }
    }

    fun getTotalAmountRemaining(): Double {
        return PaymentsCalculator().getTotalRemaining(getUpcomingPaymentsList())
    }
}
