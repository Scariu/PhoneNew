package com.example.phonenew.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.phonenew.data.local.detail.CellPhoneDetailEntity
import com.example.phonenew.data.local.list.CellPhoneEntity

@Dao
interface CellPhoneDAO {

    //Lista
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCellPhones(cellPhoneEntity: List<CellPhoneEntity>)

    @Query("Select * from table_cell_phones order by id ASC")
    fun getCellPhones(): LiveData<List<CellPhoneEntity>>

    //Detalle
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCellPhoneDetails(cellPhoneDetailEntity: CellPhoneDetailEntity)

    @Query("Select * from table_cell_phones_details WHERE id = :id")
    fun getCellPhoneDetails(id: Long): LiveData<CellPhoneDetailEntity>
}