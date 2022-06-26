package com.example.gameofthroneshouses.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthroneshouses.Model.House
import com.example.gameofthroneshouses.repository.GotRepository
import com.example.gameofthroneshouses.view.Messages
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class GotViewModel constructor(private val repository: GotRepository) : ViewModel() {

    val queryHousesResult = MutableLiveData<List<House>>()
    val errorMessage = MutableLiveData<Messages>()

    fun queryAllHouses() {

        val call=repository.queryAllHouses(errorMessage)
        call?.let {
            call.enqueue(object : Callback<ResponseBody?> {
                    override fun onResponse(
                        call: Call<ResponseBody?>,
                        response: Response<ResponseBody?>
                    ) {
                        //Success -> convert Json to Object and put it to ResultList
                        if (response.isSuccessful) {
                            val requireNonNull = Objects.requireNonNull(response.body())
                            val responseReceived = requireNonNull?.string()

                            val houseListType = object : TypeToken<ArrayList<House?>?>() {}.type
                            queryHousesResult.postValue(
                                Gson().fromJson(
                                    responseReceived,
                                    houseListType
                                )
                            )

                        } else {
                            errorMessage.postValue(Messages.SERVER_NOT_AVAILABLE)
                        }
                    }

                    override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                        errorMessage.postValue(Messages.SERVER_NOT_AVAILABLE)
                    }

                })
            }
        }


}