package com.example.phonenew.data.remote.detail

data class CellPhoneDetail(
    val id: Long,
    val name: String,
    val price: Long,
    val image: String,
    val description: String,
    val lastPrice: Long,
    val credit: Boolean
)