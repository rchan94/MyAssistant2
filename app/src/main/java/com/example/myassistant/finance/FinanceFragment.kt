package com.example.myassistant.finance


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myassistant.R
import kotlinx.android.synthetic.main.fragment_finance.*


class FinanceFragment : Fragment() {

    private lateinit var financeViewModel: FinanceViewModel
    private var paymentList: List<Payment> = listOf()
    val viewManager = LinearLayoutManager(this.context)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        financeViewModel = ViewModelProviders.of(this).get(FinanceViewModel::class.java)
        financeViewModel.loadPayments()
        financeViewModel.loadTotalPaymentRemaining()
        financeViewModel.monthlyPaymentsList.observe(this, Observer { updatePaymentsList(it) })
        financeViewModel.totalRemainingPayment.observe(this, Observer { updateTotalPaymentRemaining(it) })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_finance, container, false)
    }

    private fun updatePaymentsList(payments: List<Payment>) {
        paymentList = payments
        finance_recycler_view.apply {
            layoutManager = viewManager
            adapter = FinanceAdapter(paymentList)
        }
    }

    private fun updateTotalPaymentRemaining(totalRemainingPayment: Double?) {
        text_view_payment_value.text = "£${totalRemainingPayment.toString()}"
    }
}
