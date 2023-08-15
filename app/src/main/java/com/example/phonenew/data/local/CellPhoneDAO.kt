package com.example.phonenew.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CellPhoneDAO {

    //Lista
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCellPhones(cellPhoneEntity: List<CellPhoneEntity>)

    @Query("Select * from tabla_cell_phones order by id ASC")
    fun getCellPhones(): LiveData<List<CellPhoneEntity>>

}