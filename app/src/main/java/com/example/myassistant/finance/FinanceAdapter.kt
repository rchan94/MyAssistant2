package com.example.myassistant.finance

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myassistant.R
import kotlinx.android.synthetic.main.item_payment.view.*
import java.util.*

class FinanceAdapter(private val financeList: List<Payment>)
    : RecyclerView.Adapter<FinanceAdapter.FinanceViewHolder>() {
    class FinanceViewHolder(val textView: View) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinanceViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_payment, parent, false)

        return FinanceViewHolder(textView)
    }

    override fun onBindViewHolder(holder: FinanceViewHolder, position: Int) {
        holder.textView.item_description_value.text = financeList[position].description
        holder.textView.item_date_value.text = "${financeList[position].day}/${getDateExtension()}"
        holder.textView.item_payment_value.text = "£${financeList[position].amount}"
        holder.textView.imageView.setImageDrawable(getImage())
    }

    private fun getImage(): Drawable? {
        return R.drawable.savings as Drawable
    }

    override fun getItemCount(): Int = financeList.size

    private fun getDateExtension(): String {
        val month = Calendar.getInstance().get(Calendar.DAY_OF_MONTH).toString()
        val year = Calendar.getInstance().get(Calendar.YEAR).toString()
        return "$month/$year"
    }
}