package com.example.phonenew.data.local.detail

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_cell_phones_details")
data class CellPhoneDetailEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val price: Long,
    val image: String,
    val description: String,
    val lastPrice: Long,
    val credit: Boolean
)
