package com.example.next.model

import com.google.gson.annotations.SerializedName

data class Account (
    @SerializedName("id")
    val id: String,
    @SerializedName("customer_name")
    val customerName: String,
    @SerializedName("account_no")
    val accountNo: String,
    @SerializedName("account_type")
    val accountType: String,
    @SerializedName("balance")
    val balance: String,
    )

