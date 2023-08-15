package com.example.phonenew.data.remote

import com.example.phonenew.data.remote.detail.CellPhoneDetail
import com.example.phonenew.data.remote.list.CellPhone
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CellPhoneAPI {

    //Lista
    @GET("products/")
    suspend fun getDataCellPhone(): Response<List<CellPhone>>

    //Detalle
    @GET("details/{id}")
    suspend fun getDataCellPhoneDetails(@Path("id") id: Long): Response<CellPhoneDetail>
}
