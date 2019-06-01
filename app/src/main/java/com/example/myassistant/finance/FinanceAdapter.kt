package com.example.myassistant.finance

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
        holder.textView.imageView.setImageResource(getImage(financeList[position].type))
    }

    private fun getImage(type: Type): Int {
        return when(type) {
            Type.CAR -> R.drawable.car
            Type.MONEY -> R.drawable.savings
            Type.MUSIC -> R.drawable.music
            Type.PHONE -> R.drawable.phone
            Type.SPORTS -> R.drawable.sports
            Type.TV -> R.drawable.tv
        }
    }

    override fun getItemCount(): Int = financeList.size

    private fun getDateExtension(): String {
        val month = Calendar.getInstance().get(Calendar.MONTH) + 1
        val year = Calendar.getInstance().get(Calendar.YEAR)
        return "$month/$year"
    }
}