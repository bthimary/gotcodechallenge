package com.example.gameofthroneshouses.Rest

import androidx.lifecycle.MutableLiveData
import com.example.gameofthroneshouses.Model.House
import org.junit.Test


internal class GotCommunicatorTest {

   @Test
    fun queryAllHouses() {
       var queryResultList: MutableLiveData<List<House>> = MutableLiveData()
      GotCommunicator.queryAllHouses(queryResultList)


    }
}