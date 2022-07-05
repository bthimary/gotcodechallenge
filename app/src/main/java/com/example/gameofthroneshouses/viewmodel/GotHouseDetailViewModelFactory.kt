package com.example.gameofthroneshouses.viewmodel

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.gameofthroneshouses.repository.GotHouseDetailRepository
import com.example.gameofthroneshouses.view.Messages


class GotHouseDetailViewModelFactory constructor(
    /**
     * [GotHouseDetailRepository] which is used to get Data from REST
     */
    private val repository: GotHouseDetailRepository,
    /** [SavedStateRegistryOwner] that will provide restored state for created[ViewModel]. */
    owner: SavedStateRegistryOwner?,
    /**
     * Values from this [Bundle] will be used to Transfer Data .
     *
     */
    private val defaultArgs: Bundle?,

    /** current Android application */
    private val application: Application,
    /**     */
    private val errorMessages: MutableLiveData<Messages>
) : AbstractSavedStateViewModelFactory(owner!!, defaultArgs) {
    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        state: SavedStateHandle
    ): T {
        return if (modelClass.isAssignableFrom(GotHouseDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            GotHouseDetailViewModel(repository, defaultArgs, application,errorMessages) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}