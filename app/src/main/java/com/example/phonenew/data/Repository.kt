package com.example.phonenew.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.phonenew.data.local.CellPhoneDAO
import com.example.phonenew.data.local.detail.CellPhoneDetailEntity
import com.example.phonenew.data.local.list.CellPhoneEntity
import com.example.phonenew.data.remote.list.CellPhone

import com.example.phonenew.data.remote.CellPhoneAPI
import com.example.phonenew.data.remote.detail.CellPhoneDetail

class Repository(private val cellPhoneAPI: CellPhoneAPI, private val cellPhoneDAO: CellPhoneDAO) {
    fun getCellPhonesFromEntity(): LiveData<List<CellPhoneEntity>> =
        cellPhoneDAO.getCellPhones()

    fun getCellPhoneDetailsFromEntity(id: Long): LiveData<CellPhoneDetailEntity> =
        cellPhoneDAO.getCellPhoneDetails(id)

    suspend fun getCellPhones() {
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

    suspend fun getCellPhoneDetails(id: Long) {
        try {
            val response = cellPhoneAPI.getDataCellPhoneDetails(id) // Aqui llegan los datos
            if (response.isSuccessful) { //Evalua si llegaron los datos
                val resp = response.body() // Solo obtiene la respuesta, no tiene status
                resp?.let {
                    val cellPhoneDetailEntity = it.transformToDetailEntity()
                    cellPhoneDAO.insertCellPhoneDetails(cellPhoneDetailEntity)
                }
            }
        } catch (exception: Exception) {
            Log.e("catch", "")
        }
    }
}

