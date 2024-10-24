package com.example.features.vacancy_screen.ui.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.features.vacancy_screen.ui.adapter.item.LocationItem
import com.example.features.vacancy_screen.databinding.ItemLocationBinding

class LocationViewHolder(private val binding: ItemLocationBinding) : ViewHolder(binding.root) {
    fun bind(item: LocationItem) {
        binding.tvCompanyName.text = item.companyName
        binding.tvAddress.text = item.address
    }
}