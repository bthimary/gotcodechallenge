package com.example.gameofthroneshouses.viewmodel

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import com.example.gameofthroneshouses.model.House
import com.example.gameofthroneshouses.view.activity.MainActivity


class HouseSelectHandler {
    private val TAG = "HouseSelectetHandler"
    fun onClick(view: View, house: House) {
        Log.i(TAG,"clicked")
        val context: Context = view.getContext()
        val intent = Intent(context, MainActivity::class.java)
        intent.putExtra("SelectedHouse", house)
        context.startActivity(intent)
    }

}