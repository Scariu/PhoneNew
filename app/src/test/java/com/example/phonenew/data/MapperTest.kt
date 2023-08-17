package com.example.phonenew.data

import com.example.phonenew.data.remote.detail.CellPhoneDetail
import com.example.phonenew.data.remote.list.CellPhone
import org.junit.Assert.*

import org.junit.Test

class MapperTest {

    @Test
    fun transformToEntity() {
        //Given(dado este valor)
        val cellPhone = CellPhone(1, "Huawei", 100000, "wwww.image.cl")

        //When(hago esta acción)
        val resultadoTransformacionCellPhone = cellPhone.transformToEntity()

        //Then(espero este resultado)
        assertEquals(cellPhone.id, resultadoTransformacionCellPhone.id)
        assertEquals(cellPhone.name, resultadoTransformacionCellPhone.name)
        assertEquals(cellPhone.price, resultadoTransformacionCellPhone.price)
        assertEquals(cellPhone.image, resultadoTransformacionCellPhone.image)
    }

    @Test
    fun transformToDetailEntity() {
        //Given(dado este valor)
        val cellPhoneDetail =
            CellPhoneDetail(1, "Huawei", 100000, "wwww.image.cl", "10pulgadas", 200000, true)

        //When(hago esta acción)
        val resultadoTransformacionCellPhoneDetail = cellPhoneDetail.transformToDetailEntity()

        //Then(espero este resultado)
        assertEquals(cellPhoneDetail.id, resultadoTransformacionCellPhoneDetail.id)
        assertEquals(cellPhoneDetail.name, resultadoTransformacionCellPhoneDetail.name)
        assertEquals(cellPhoneDetail.price, resultadoTransformacionCellPhoneDetail.price)
        assertEquals(cellPhoneDetail.image, resultadoTransformacionCellPhoneDetail.image)
        assertEquals(
            cellPhoneDetail.description,
            resultadoTransformacionCellPhoneDetail.description
        )
        assertEquals(cellPhoneDetail.lastPrice, resultadoTransformacionCellPhoneDetail.lastPrice)
        assertEquals(cellPhoneDetail.credit, resultadoTransformacionCellPhoneDetail.credit)
    }
}