package com.example.gameofthroneshouses.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gameofthroneshouses.repository.GotMainRepository
import com.example.gameofthroneshouses.view.adapter.GotHouseAdapter

@Suppress("UNCHECKED_CAST")
class GotMainViewModelFactory constructor(private val repository: GotMainRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(GotMainViewModel::class.java)) {
            GotMainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}