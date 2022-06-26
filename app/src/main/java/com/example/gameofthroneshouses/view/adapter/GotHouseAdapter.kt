package com.example.gameofthroneshouses.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthroneshouses.Model.House
import com.example.gameofthroneshouses.databinding.GotHousesItemBinding


class GotHouseAdapter: RecyclerView.Adapter<GofHouseViewHolder>() {
    var houses= mutableListOf<House>()
    fun setHouseList(houses: List<House>){
        this.houses=houses.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GofHouseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GotHousesItemBinding.inflate(inflater, parent, false)
        return GofHouseViewHolder(binding)
    }
    override fun onBindViewHolder(holder: GofHouseViewHolder, position: Int) {
        val movie = houses[position]
        holder.binding.name.text = movie.name

    }
    override fun getItemCount(): Int {
        return houses.size
    }
}


class GofHouseViewHolder(val binding: GotHousesItemBinding): RecyclerView.ViewHolder(binding.root) {
}