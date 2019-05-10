package com.example.myassistant.finance

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class PaymentsCalculatorTest {
    private val calculator = PaymentsCalculator()

    @Test
    fun `return 100,00 given 1 future payments of 100`() {
        val paymentsList = listOf(Payment(5, 100.00, false, "test"))
        assertThat(100.00, equalTo(calculator.getTotalRemaining(paymentsList, 1)))
    }

    @Test
    fun `return 200 given 2 future payments of 100 and 1 past payment of 50`() {
        val paymentsList = listOf(
            Payment(2, 50.00, false, "test"),
            Payment(6, 100.00, false, "test"),
            Payment(6, 100.00, false, "test")
        )

        assertThat(200.00, equalTo(calculator.getTotalRemaining(paymentsList, 5)))
    }

    @Test
    fun `return 300 given 1 future payment of 300 and 1 present payment of 100`() {
        val paymentsList = listOf(
            Payment(5, 100.00, false, "test"),
            Payment(25, 300.00, false, "test")
        )

        assertThat(300.00, equalTo(calculator.getTotalRemaining(paymentsList, 5)))
    }
}