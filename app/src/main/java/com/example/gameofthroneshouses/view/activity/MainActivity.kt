package com.example.gameofthroneshouses.view.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.gameofthroneshouses.R
import com.example.gameofthroneshouses.databinding.ActivityMainBinding
import com.example.gameofthroneshouses.repository.GotRepository
import com.example.gameofthroneshouses.rest.GotRestApiService
import com.example.gameofthroneshouses.view.adapter.GotHouseAdapter
import com.example.gameofthroneshouses.viewmodel.GotViewModel
import com.example.gameofthroneshouses.viewmodel.GotViewModelFactory

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: GotViewModel
    private val gotRestApiService= GotRestApiService.getInstance()
    val houseAdapter= GotHouseAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel= ViewModelProvider(this,
        GotViewModelFactory(GotRepository(gotRestApiService,applicationContext))).get(GotViewModel::class.java)

        binding.houserrecyclerview.adapter=houseAdapter

        viewModel.queryHousesResult.observeForever {
            Log.i(TAG, "onCreate:$it")
            houseAdapter.setHouseList(it)
        }
        viewModel.errorMessage.observeForever {
            Toast.makeText(this,it.text,Toast.LENGTH_LONG).show()
        }
        viewModel.queryAllHouses()
    }


}