package com.example.next.retrofit

import com.example.next.model.Account
import com.example.next.model.Transactions
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("getDetail/account")
    fun getDetailAccount() : Call<List<Account>>

    @GET("getDetail/transactions")
    fun getTransactions() : Call<List<Transactions>>

}