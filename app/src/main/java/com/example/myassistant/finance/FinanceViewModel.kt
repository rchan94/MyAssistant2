package com.example.myassistant.finance

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myassistant.useCase.GetPaymentsUseCase

class FinanceViewModel : ViewModel() {

    var monthlyPaymentsList: MutableLiveData<List<Payment>> = MutableLiveData()
    var totalRemainingPayment: MutableLiveData<Double> = MutableLiveData()

    fun loadPayments() = monthlyPaymentsList.postValue(GetPaymentsUseCase().getPayments())

    fun loadTotalPaymentRemaining() = totalRemainingPayment.postValue(GetPaymentsUseCase().getTotalAmountRemaining())

}
