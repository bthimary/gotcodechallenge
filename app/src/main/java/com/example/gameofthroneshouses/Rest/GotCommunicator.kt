package com.example.gameofthroneshouses.Rest

import androidx.lifecycle.MutableLiveData
import com.example.gameofthroneshouses.Model.House
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


object GotCommunicator {

    fun queryAllHouses(queryHousesResult: MutableLiveData<List<House>>) {
        //TODO: Check Internet
        val call = GotRestApiFactory.api.queryAllHouses()
        call.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
                if (response.isSuccessful) {
                    val responseReceived = Objects.requireNonNull(response.body())?.string()

                    val houseListType = object : TypeToken<ArrayList<House?>?>() {}.type
                    queryHousesResult.postValue( Gson().fromJson(responseReceived, houseListType))

                } else {
                    //TODO:Fehlerfallbehandeln
                }
            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


}