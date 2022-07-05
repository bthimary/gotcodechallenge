package com.example.gameofthroneshouses.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.gameofthroneshouses.model.AdditionalHouseValues
import com.example.gameofthroneshouses.model.Character
import com.example.gameofthroneshouses.repository.GotHouseDetailRepository
import com.example.gameofthroneshouses.rest.GotUrlUtil
import com.example.gameofthroneshouses.view.Messages
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class AdditionalHouseValuesUtil(
    val additionalHouseValues: AdditionalHouseValues,
    val repository: GotHouseDetailRepository,
    var errorMessages: MutableLiveData<Messages>
) {

    fun fillAdditionals() {
        //heir
        val liveHeir = MutableLiveData<Character>()
        liveHeir.observeForever {
            additionalHouseValues.heir = liveHeir.value
        }
        additionalHouseValues.house.heir?.let {
            sendRequestforId(GotUrlUtil.getCharacterIdFromUrl(it), liveHeir)
        }

        //currentLord
        val liveCurrentLord = MutableLiveData<Character>()
        liveCurrentLord.observeForever {
            additionalHouseValues.currentLord = liveCurrentLord.value
        }
        additionalHouseValues.house.currentLord?.let {
            sendRequestforId(GotUrlUtil.getCharacterIdFromUrl(it), liveCurrentLord)
        }

        //founder
        val liveFounder = MutableLiveData<Character>()
        liveFounder.observeForever {
            additionalHouseValues.founder = liveFounder.value
        }
        additionalHouseValues.house.founder?.let {
            sendRequestforId(GotUrlUtil.getCharacterIdFromUrl(it), liveFounder)
        }

        //overlord
        val liveOverLord = MutableLiveData<Character>()
        liveOverLord.observeForever {
            additionalHouseValues.overlord = liveOverLord.value
        }
        additionalHouseValues.house.overlord?.let {
            sendRequestforId(GotUrlUtil.getCharacterIdFromUrl(it), liveOverLord)
        }


    }


    private fun sendRequestforId(id: String, responseCharacter: MutableLiveData<Character>) {
        if (GotUrlUtil.NO_CORRECT_URL == id || GotUrlUtil.NO_NUMBER == id) {
            return
        }
        repository
        val request = repository.queryGetCharacter(id)
        request.let {
            request.enqueue(object : Callback<ResponseBody?> {
                override fun onResponse(
                    call: Call<ResponseBody?>,
                    response: Response<ResponseBody?>
                ) {
                    //Success -> convert Json to Object and put it to ResultList
                    if (response.isSuccessful) {
                        val requireNonNull = Objects.requireNonNull(response.body())
                        val responseReceived = requireNonNull?.string()

                        val characterListType = object : TypeToken<Character?>() {}.type
                        responseCharacter.postValue(
                            Gson().fromJson(responseReceived, characterListType)
                        )

                    } else {
                        errorMessages.postValue(Messages.SERVER_NOT_AVAILABLE)
                    }
                }

                override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                    errorMessages.postValue(Messages.SERVER_NOT_AVAILABLE)
                }

            })
        }
    }
}
