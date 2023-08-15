package com.example.phonenew.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface CellPhoneAPI {
    @GET("products/")
    suspend fun getDataCellPhone(): Response<List<CellPhone>>
}
