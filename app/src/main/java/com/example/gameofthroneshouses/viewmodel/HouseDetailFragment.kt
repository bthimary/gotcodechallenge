package com.example.gameofthroneshouses.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.gameofthroneshouses.databinding.HouseDetailFragmentBinding
import com.example.gameofthroneshouses.view.Messages
import com.example.gameofthroneshouses.view.activity.HouseDetailActivity

class HouseDetailFragment : Fragment() {

    /** the associated view model*/
    lateinit var viewModel: GotHouseDetailViewModel

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val houseDetailActivity = activity as HouseDetailActivity
        val errorMessages = MutableLiveData<Messages>()
        viewModel = ViewModelProvider(
            houseDetailActivity, GotHouseDetailViewModelFactory(
                houseDetailActivity.repository,
                this, houseDetailActivity.intent.extras,
                houseDetailActivity.application,
                errorMessages
            )
        ).get(GotHouseDetailViewModel::class.java)

        viewModel.showHouseDetails()

        errorMessages.observeForever {
            Toast.makeText((activity as HouseDetailActivity).applicationContext, it.text, Toast.LENGTH_LONG).show()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = HouseDetailFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return  binding.root

    }


}