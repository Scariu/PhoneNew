package com.example.phonenew.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CellPhoneRetrofit {
    companion object {
        private const val URL_BASE = "https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/"

        fun getCellPhoneRetrofit(): CellPhoneAPI {
            val mRetrofit = Retrofit.Builder().baseUrl(URL_BASE).addConverterFactory(
                GsonConverterFactory.create()
            ).build()
            return mRetrofit.create(CellPhoneAPI::class.java)
        }
    }
}
