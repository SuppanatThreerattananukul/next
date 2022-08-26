package com.example.next.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.next.R
import com.example.next.model.Transactions
import kotlinx.android.synthetic.main.item_transactions.view.*

class TransactionsAdapter (private val transactions: List<Transactions>, private val transactionsListener: TransactionsListener): RecyclerView.Adapter<TransactionsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_transactions, parent, false))
    }

    override fun getItemCount() = transactions.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(transactions[position])
        holder.itemView.setOnClickListener {
            transactionsListener.onItemClick()
        }
    }

    class ViewHolder(itemsView: View): RecyclerView.ViewHolder(itemsView) {
        fun bind(transactions: Transactions) {

            itemView.apply {
                when (transactions.type) {
                    "withdraw" -> {
                        layoutWithdraw.visibility = View.VISIBLE
                        textAtmId.text = transactions.atmId
                        textType.text = "Cardless ATM"
                        textTime.text = transactions.time
                        textTransactions.text = "-"+ transactions.balance
                        textTransactions.setTextColor(Color.RED)
                    }
                    "payment" -> {
                        layoutPayment.visibility = View.VISIBLE
                        textDescription.text = transactions.description
                        textType.text = "Payment"
                        textTime.text = transactions.time
                        textTransactions.text = "-"+ transactions.balance
                        textTransactions.setTextColor(Color.RED)
                    }
                    "trans_out_promtpay" -> {
                        layoutTransferOutPromptpay.visibility = View.VISIBLE
                        textToPromptpay.text = transactions.fromNo
                        textToPromptpayName.text = transactions.fromName
                        textChannel.text = transactions.channel
                        textType.text = "Transfer\nout-PromptPay"
                        textTime.text = transactions.time
                        textTransactions.text = "-"+ transactions.balance
                        textTransactions.setTextColor(Color.RED)
                    }
                    "trans_out" -> {
                        layoutTransferOut.visibility = View.VISIBLE
                        textToBank.text = transactions.fromBank
                        textToNoAccount.text = transactions.fromNo
                        textToName.text = transactions.fromName
                        textType.text = "Transfer out"
                        textTime.text = transactions.time
                        textTransactions.text = "-"+ transactions.balance
                        textTransactions.setTextColor(Color.RED)
                    }
                    "trans_in_promtpay" -> {
                        layoutTransferOutPromptpay.visibility = View.VISIBLE
                        textFromPromptpay.text = transactions.fromBank
                        textFromPromptpayNo.text = transactions.fromNo
                        textType.text = "Transfer\nin-PromptPay"
                        textTime.text = transactions.time
                        textTransactions.text = "+"+ transactions.balance
                        textTransactions.setTextColor(Color.GREEN)
                    }
                    "trans_in" -> {
                        layoutTransferIn.visibility = View.VISIBLE
                        textBank.text = transactions.fromBank
                        textNoAccount.text = transactions.fromNo
                        textFromName.text = transactions.fromName
                        textType.text = "Transfer in"
                        textTime.text = transactions.time
                        textTransactions.text = "+"+ transactions.balance
                        textTransactions.setTextColor(Color.GREEN)
                    }
                }
            }
        }
    }

}