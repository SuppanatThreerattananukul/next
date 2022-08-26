package com.example.next.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.next.model.Account
import com.example.next.model.Transactions
import com.example.next.repository.MainRepository


class MainViewModel : ViewModel() {

    var accountLiveData: MutableLiveData<List<Account>>? = null
    var transactionsLiveData: MutableLiveData<List<Transactions>>? = null

    fun getAccout() : LiveData<List<Account>>? {
        accountLiveData = MainRepository.getAccount()
        return accountLiveData
    }

    fun getTransactions() : LiveData<List<Transactions>>? {
        transactionsLiveData = MainRepository.getTransactions()
        return transactionsLiveData
    }

}