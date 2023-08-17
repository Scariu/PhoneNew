package com.example.phonenew.data

import com.example.phonenew.data.local.detail.CellPhoneDetailEntity
import com.example.phonenew.data.local.list.CellPhoneEntity
import com.example.phonenew.data.remote.detail.CellPhoneDetail
import com.example.phonenew.data.remote.list.CellPhone

fun CellPhone.transformToEntity(): CellPhoneEntity =
    CellPhoneEntity(this.id, this.name, this.price, this.image)

fun CellPhoneDetail.transformToDetailEntity(): CellPhoneDetailEntity =
    CellPhoneDetailEntity(
        this.id,
        this.name,
        this.price,
        this.image,
        this.description,
        this.lastPrice,
        this.credit
    )