package com.example.next.model

import com.google.gson.annotations.SerializedName

data class Transactions (
    @SerializedName("id")
    val id: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("from_no")
    val fromNo: String,
    @SerializedName("from_name")
    val fromName: String,
    @SerializedName("from_bank")
    val fromBank: String,
    @SerializedName("atm_id")
    val atmId: String,
    @SerializedName("balance")
    val balance: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("channel")
    val channel: String,
    )

