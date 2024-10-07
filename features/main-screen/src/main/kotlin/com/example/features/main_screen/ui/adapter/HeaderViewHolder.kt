package com.example.features.main_screen.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.features.main_screen.databinding.ItemClHeaderBinding
import com.example.features.main_screen.ui.adapter.items.HeaderItem


class HeaderViewHolder(private val binding: ItemClHeaderBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: HeaderItem) {
        binding.tvAmountOfVacancies.text = "${item.vacancyNumber} ${item.vacancyWord}"
    }
}