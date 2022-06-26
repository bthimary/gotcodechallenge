package com.example.gameofthroneshouses.rest

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface GotRestApiService {

    @GET("api/houses")
    fun queryAllHouses(): Call<ResponseBody?>

    @GET("api/characters/")
    fun queryCharacterById(): Call<ResponseBody>

    companion object {
        const val BASEURL = "https://anapioficeandfire.com/"
        const val TIMEOUT: Long = 100
        var retrofit: Retrofit? = null
        var gotRestService: GotRestApiService? = null
        fun buildRetrofit(): Retrofit {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val okHttpClient = OkHttpClient.Builder()
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build()
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return retrofit!!
        }

        fun getInstance(): GotRestApiService {
            if (gotRestService == null) {
                val retrofit = buildRetrofit()
                gotRestService = retrofit.create(GotRestApiService::class.java)
            }
            return gotRestService!!
        }
    }
}