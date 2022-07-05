package com.example.gameofthroneshouses.viewmodel

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.gameofthroneshouses.model.AdditionalHouseValues
import com.example.gameofthroneshouses.model.House
import com.example.gameofthroneshouses.repository.GotHouseDetailRepository
import com.example.gameofthroneshouses.view.Messages

class GotHouseDetailViewModel constructor(
    private val respository: GotHouseDetailRepository,
    defaultArgs: Bundle?,
    /** Associated Android application. */
    application: Application,
    /** errorMessages*/
    val errorMessages: MutableLiveData<Messages>
) : AndroidViewModel(application) {
    /** house to be displayed*/
    val house = defaultArgs?.get("House") as House

    /** AddidionalHouseValues which will be diplayed after Query */
    val additionalHouseValues = AdditionalHouseValues(house)


    fun showHouseDetails() {
        house
        AdditionalHouseValuesUtil(
            additionalHouseValues,
            respository,
            errorMessages
        ).fillAdditionals()


    }


}