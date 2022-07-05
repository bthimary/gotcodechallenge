package com.example.gameofthroneshouses.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.gameofthroneshouses.databinding.HouseDetailActivityBinding
import com.example.gameofthroneshouses.repository.GotHouseDetailRepository
import com.example.gameofthroneshouses.rest.GotRestApiService
import com.example.gameofthroneshouses.view.Messages
import com.example.gameofthroneshouses.viewmodel.GotHouseDetailViewModel
import com.example.gameofthroneshouses.viewmodel.GotHouseDetailViewModelFactory

class HouseDetailActivity :AppCompatActivity() {
     val ARG_ITEM_POS="housePOS"

    lateinit var viewModel:GotHouseDetailViewModel
    private val gotRestApiService= GotRestApiService.getInstance()
    val repository= GotHouseDetailRepository(gotRestApiService)
    private lateinit var binding: HouseDetailActivityBinding
    private val messages= MutableLiveData<Messages>()
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.house_detail_fragment)
        setContentView(binding.root)
        viewModel= ViewModelProvider(this,
            GotHouseDetailViewModelFactory(repository,
                this,intent.extras,application,messages)
        ).get(GotHouseDetailViewModel::class.java)

    }
}