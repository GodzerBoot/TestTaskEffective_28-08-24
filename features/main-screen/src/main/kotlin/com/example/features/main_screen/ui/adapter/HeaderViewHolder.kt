package com.example.features.main_screen.ui.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.features.main_screen.databinding.ItemClHeaderBinding
import com.example.features.main_screen.ui.adapter.item.HeaderItem


class HeaderViewHolder(private val binding: ItemClHeaderBinding) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(item: HeaderItem) {
        binding.tvAmountOfVacancies.text = "${item.vacancyNumber} ${item.vacancyWord}"
    }
}