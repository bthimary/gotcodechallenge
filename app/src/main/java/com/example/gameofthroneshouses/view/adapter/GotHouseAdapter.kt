package com.example.gameofthroneshouses.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthroneshouses.R
import com.example.gameofthroneshouses.databinding.GotHousesAdapterBinding
import com.example.gameofthroneshouses.model.House

/** Tag for Log Information*/
private val tag = "GotHouseAdapter"

class GotHouseAdapter() :
    RecyclerView.Adapter<GotHouseViewHolder>() {
    private var houses = mutableListOf<House>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GotHouseViewHolder {
        // connect Binding between Adapter and LayoutItem
        val binding = DataBindingUtil.inflate<GotHousesAdapterBinding>(
            LayoutInflater.from(parent.context),
            R.layout.got_houses_adapter, parent, false
        )
        Log.i(tag, "onCreateViewHolder")
        return GotHouseViewHolder(binding)
    }

    fun setHouseList(houses: List<House>) {
        this.houses = houses.toMutableList()
        notifyDataSetChanged()

    }
    override fun onBindViewHolder(holder: GotHouseViewHolder, position: Int) {
        val house = houses[position]
        holder.bindView(house)
    }

    override fun getItemCount(): Int {
        return houses.size
    }
}



class GotHouseViewHolder(val binding: GotHousesAdapterBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindView(house: House){
            binding.house = house
            binding.name.text=house.name
        }
}