package com.example.features.vacancy_screen.ui.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.features.vacancy_screen.ui.adapter.item.ApplyItem
import com.example.features.vacancy_screen.databinding.ItemApplyBinding

class ApplyViewHolder(private val binding: ItemApplyBinding) : ViewHolder(binding.root) {
    fun bind(item: ApplyItem) {
        binding.btnApply.setOnClickListener(item.clickListener)
    }
}