package com.example.next.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.next.R
import com.example.next.model.Account
import kotlinx.android.synthetic.main.item_account.view.*

class AccountAdapter(private val account: List<Account>) : RecyclerView.Adapter<AccountAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_account, parent, false))
    }

    override fun getItemCount() = account.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(account[position])
    }

    class ViewHolder(itemsView: View): RecyclerView.ViewHolder(itemsView) {
        fun bind(account: Account) {
            itemView.apply {
                textName.text = account.customerName
                textType.text = account.accountType
                textNo.text = account.accountNo
                textCurrentBalance.text = account.balance
                textCurBalance.text = account.balance
            }
        }
    }

}