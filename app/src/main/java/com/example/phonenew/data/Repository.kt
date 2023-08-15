package com.example.phonenew.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.phonenew.data.local.CellPhoneDAO
import com.example.phonenew.data.local.CellPhoneEntity
import com.example.phonenew.data.remote.CellPhone

import com.example.phonenew.data.remote.CellPhoneAPI

class Repository(private val cellPhoneAPI: CellPhoneAPI, private val cellPhoneDAO: CellPhoneDAO) {
    suspend fun getCellPhones() {

        fun getCellPhonesFromEntity(): LiveData<List<CellPhoneEntity>> =
            cellPhoneDAO.getCellPhones()

        try {
            val response = cellPhoneAPI.getDataCellPhone() // Aqui llegan los datos
            if (response.isSuccessful) { //Evalua si llegaron los datos
                val resp = response.body() // Solo obtiene la respuesta, no tiene status
                resp?.let {
                    val cellPhoneEntity = it.map { it.transformToEntity() }
                    cellPhoneDAO.insertCellPhones(cellPhoneEntity)
                }
            }
        } catch (exception: Exception) {
            Log.e("catch", "")
        }
    }
}

fun CellPhone.transformToEntity(): CellPhoneEntity =
    CellPhoneEntity(this.id, this.name, this.price, this.image)