package com.example.gameofthroneshouses.view.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.gameofthroneshouses.databinding.ActivityMainBinding
import com.example.gameofthroneshouses.repository.GotMainRepository
import com.example.gameofthroneshouses.rest.GotRestApiService
import com.example.gameofthroneshouses.view.adapter.GotHouseAdapter
import com.example.gameofthroneshouses.viewmodel.GotMainViewModel
import com.example.gameofthroneshouses.viewmodel.GotMainViewModelFactory

class MainActivity : AppCompatActivity() {
    /** Tag for Log Information*/
    private val tag = "MainActivity"

    /** Binding in MainActivity */
    private lateinit var binding: ActivityMainBinding

    /** viewModel of the MainActivity*/
    lateinit var viewModel: GotMainViewModel

    /** RestApi for getting House-Data from */
    private val gotRestApiService = GotRestApiService.getInstance()

    /** Adapter for Display Houses*/
    private var houseAdapter = GotHouseAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //init binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.houserrecyclerview.adapter = houseAdapter
        setContentView(binding.root)

        //initialize view model
        viewModel = ViewModelProvider(
            this,
            GotMainViewModelFactory(
                GotMainRepository(gotRestApiService, applicationContext)
            )
        ).get(GotMainViewModel::class.java)


        //Set Houses when get response
        viewModel.queryHousesResult.observeForever {
            Log.i(tag, "setHouseList:$it")
            houseAdapter.setHouseList(it)
        }
        // Display Errors if there are one
        viewModel.errorMessage.observeForever {
            Toast.makeText(this, it.text, Toast.LENGTH_LONG).show()
        }
        // run Api for Query
        viewModel.queryAllHouses()

    }
}
