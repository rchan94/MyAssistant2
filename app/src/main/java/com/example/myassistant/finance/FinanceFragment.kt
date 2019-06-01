package com.example.myassistant.finance


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myassistant.R
import kotlinx.android.synthetic.main.finance_header.*
import kotlinx.android.synthetic.main.fragment_finance.*


class FinanceFragment : Fragment() {

    private lateinit var financeViewModel: FinanceViewModel
    private var paymentList: List<Payment> = listOf()
    private val viewManager = LinearLayoutManager(this.context)


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        floating_add_button.setOnClickListener {
            Toast.makeText(context, "Add button clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updatePaymentsList(payments: List<Payment>) {
        paymentList = payments
        val divider = DividerItemDecoration(finance_recycler_view.context, LinearLayoutManager.VERTICAL).apply {
            setDrawable(resources.getDrawable(R.drawable.short_divider, null))
        }
        finance_recycler_view.apply {
            layoutManager = viewManager
            adapter = FinanceAdapter(paymentList)
            addItemDecoration(divider)
        }
    }

    private fun updateTotalPaymentRemaining(totalRemainingPayment: Double?) {
        text_view_payment_value.text = "£${totalRemainingPayment.toString()}"
    }
}
