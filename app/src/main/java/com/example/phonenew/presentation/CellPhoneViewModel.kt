package com.example.phonenew.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.phonenew.data.Repository
import com.example.phonenew.data.local.CellPhoneDAO
import com.example.phonenew.data.local.CellPhoneDataBase
import com.example.phonenew.data.remote.CellPhoneRetrofit
import kotlinx.coroutines.launch

class CellPhoneViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository

    init {
        val api = CellPhoneRetrofit.getCellPhoneRetrofit()
        val cellPhoneDataBase: CellPhoneDAO =
            CellPhoneDataBase.getDataBase(application).getCellPhonesDAO()
        repository = Repository(api, cellPhoneDataBase)
    }

    fun getCellPhonesViewModel() = viewModelScope.launch { repository.getCellPhones() }
}
