package com.example.phonenew.data.local.list

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_cell_phones")
data class CellPhoneEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val price: Long,
    val image: String
)
