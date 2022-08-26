package com.example.next.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.next.model.Account
import com.example.next.model.Transactions
import com.example.next.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  MainRepository {

    val account = MutableLiveData<List<Account>>()
    val transactions = MutableLiveData<List<Transactions>>()

    @JvmName("getAccount1")
    fun getAccount(): MutableLiveData<List<Account>> {

        var retrofitService: RetrofitService? = null
        val retrofit = Retrofit.Builder()
            .baseUrl("https://6305a6e8697408f7edc8dc4e.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofitService = retrofit.create(RetrofitService::class.java)

        val call = retrofitService.getDetailAccount()

        call.enqueue(object: Callback<List<Account>> {
            override fun onFailure(call: Call<List<Account>>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(call: Call<List<Account>>, response: Response<List<Account>>) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

                val msg = data!!

                account.value = msg
            }
        })

        return account
    }

    @JvmName("getTransactions1")
    fun getTransactions(): MutableLiveData<List<Transactions>> {

        var retrofitService: RetrofitService? = null
        val retrofit = Retrofit.Builder()
            .baseUrl("https://6305a6e8697408f7edc8dc4e.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofitService = retrofit.create(RetrofitService::class.java)

        val call = retrofitService.getTransactions()

        call.enqueue(object: Callback<List<Transactions>> {
            override fun onFailure(call: Call<List<Transactions>>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(call: Call<List<Transactions>>, response: Response<List<Transactions>>) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

                val msg = data!!

                transactions.value = msg
            }
        })

        return transactions
    }
}