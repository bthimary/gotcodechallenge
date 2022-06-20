package com.example.gameofthroneshouses.Rest

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface GotApiInterface {

    @GET("api/houses")
    fun queryAllHouses(): Call<ResponseBody>

    @GET("api/characters/")
    fun queryCharacterById(): Call<ResponseBody>

    @GET("Posts")
    fun getAllPosts(): Call<ResponseBody>


}