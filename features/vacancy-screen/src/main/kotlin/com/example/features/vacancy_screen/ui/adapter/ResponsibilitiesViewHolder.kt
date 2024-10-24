package com.example.features.vacancy_screen.ui.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.features.vacancy_screen.ui.adapter.item.ResponsibilitiesItem
import com.example.features.vacancy_screen.databinding.ItemResponsibilitiesBinding

class ResponsibilitiesViewHolder(private val binding: ItemResponsibilitiesBinding) : ViewHolder(binding.root) {
    fun bind(item: ResponsibilitiesItem) {
        binding.tvResponsibilities.text = item.responsibilities
    }
}