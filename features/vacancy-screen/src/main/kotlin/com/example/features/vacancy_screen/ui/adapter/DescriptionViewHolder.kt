package com.example.features.vacancy_screen.ui.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.features.vacancy_screen.ui.adapter.item.DescriptionItem
import com.example.features.vacancy_screen.databinding.ItemDescriptionBinding

class DescriptionViewHolder(private val binding: ItemDescriptionBinding) : ViewHolder(binding.root) {
    fun bind(item: DescriptionItem) {
        binding.tvDescription.text = item.description
    }
}