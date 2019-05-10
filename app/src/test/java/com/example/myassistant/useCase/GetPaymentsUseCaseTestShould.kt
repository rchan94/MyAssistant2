package com.example.myassistant.useCase

import com.example.myassistant.finance.Payment
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class GetPaymentsUseCaseTestShould {
    lateinit var getPayments: GetPaymentsUseCase

    @Before
    fun setUp() {
        getPayments = mockk()
    }

    @Test
    fun `return 31 given that the current day of the month is 31`() {
        every { getPayments.getCurrentDayOfMonth() } returns 31

        assertThat(31, equalTo(getPayments.getCurrentDayOfMonth()))
    }

    @Test
    fun `return 1 given that the current day of the month is 1`() {
        every { getPayments.getCurrentDayOfMonth() } returns 1

        assertThat(1, equalTo(getPayments.getCurrentDayOfMonth()))
    }
}