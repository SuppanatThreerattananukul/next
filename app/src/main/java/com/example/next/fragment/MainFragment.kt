package com.example.next.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.VerifiedInputEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.next.MainActivity
import com.example.next.R
import com.example.next.adapter.AccountAdapter
import com.example.next.adapter.TransactionsAdapter
import com.example.next.adapter.TransactionsListener
import com.example.next.model.Transactions
import com.example.next.viewModel.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.item_transactions.*


class MainFragment: Fragment(), TransactionsListener {

    lateinit var mainViewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
        (requireActivity() as MainActivity).supportActionBar!!.hide()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.getAccout()!!.observe(viewLifecycleOwner, Observer { account ->

            val accountAdapter = AccountAdapter(account)
            itemAccount.apply {
                layoutManager = LinearLayoutManager(context)
                isNestedScrollingEnabled = false
                adapter = accountAdapter
                onFlingListener = null
            }
            accountAdapter.notifyDataSetChanged()
            if(account.isNotEmpty()){
                getTransactions()
            }else {
                progressLoader.visibility = View.GONE
                toolbar.visibility = View.VISIBLE
                layoutNotFound.visibility = View.VISIBLE
            }
        })

    }

    private fun getTransactions() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getTransactions()!!.observe(viewLifecycleOwner, Observer { transactions ->

            val transactionsAdapter = TransactionsAdapter(transactions, this)
            itemTransactions.apply {
                layoutManager = LinearLayoutManager(context)
                isNestedScrollingEnabled = false
                adapter = transactionsAdapter
                onFlingListener = null
            }

            transactionsAdapter.notifyDataSetChanged()

            layoutNotFound.visibility = View.GONE
            progressLoader.visibility = View.GONE
            toolbar.visibility = View.VISIBLE
            layoutData.visibility = View.VISIBLE
            if(transactions.isNotEmpty()){
                itemTransactions.visibility = View.VISIBLE
                layoutTransactionsNotFound.visibility = View.GONE
            }else {
                itemTransactions.visibility = View.GONE
                layoutTransactionsNotFound.visibility = View.VISIBLE
            }

        })
    }

    override fun onItemClick() {
        imageBtLess.visibility = View.VISIBLE
        imageBtMore.visibility =View.GONE
        layoutDetailTransactions.visibility = View.VISIBLE

    }
}