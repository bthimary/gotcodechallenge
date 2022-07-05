package com.example.gameofthroneshouses.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.gameofthroneshouses.rest.GotRestApiService
import com.example.gameofthroneshouses.util.NetworkUtil
import com.example.gameofthroneshouses.view.Messages
import okhttp3.ResponseBody
import retrofit2.Call



class GotMainRepository(private val restApiService: GotRestApiService, private val context:Context) {

    /**
     * call the ApiService for Queryrequest all Houses
     * @param messages is a Callback for ErrorMessages
     * @return Call of the Rest-Service when Server get a Response
     */
    fun queryAllHouses(messages: MutableLiveData<Messages>,): Call<ResponseBody?>? {
        if (NetworkUtil.isConnectedToInternet(context)) {
           return restApiService.queryAllHouses()
        } else {
            messages.postValue(Messages.NO_INTERNET_CONNECTION)
            return null
        }
    }
}
