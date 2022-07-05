package com.example.gameofthroneshouses.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.gameofthroneshouses.model.AdditionalHouseValues
import com.example.gameofthroneshouses.model.House
import com.example.gameofthroneshouses.repository.GotHouseDetailRepository
import com.example.gameofthroneshouses.rest.GotRestApiService
import com.example.gameofthroneshouses.view.Messages
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest( GotRestApiService::class)
class AdditionalHouseValuesUtilTest {
    val  house=createTestHouse()
    @Mock
    lateinit var restApiService :GotRestApiService


    @Before
    fun initMock() {
        PowerMockito.mockStatic(GotRestApiService::class.java)

    }

    @Test
    fun fillAdditionals() {
        val repository= GotHouseDetailRepository(restApiService)
        val messages= MutableLiveData<Messages>()
       val testval= AdditionalHouseValuesUtil(AdditionalHouseValues(house),repository,messages)
        testval.fillAdditionals()
        //testval.additionalHouseValues.currentLord.
    }



    fun  createTestHouse()=
      House("https://anapioficeandfire.com/api/houses/378","My House",
          "Homeland","","my Word", listOf(""),
          listOf("seat1"),
          "https://anapioficeandfire.com/api/characters/1303","",
          "https://anapioficeandfire.com/api/characters/33",
          "",
          ""
      ,"" ,
          listOf("weapon"),
          listOf("catetBranches"),
          listOf("swornMember")
      )


}