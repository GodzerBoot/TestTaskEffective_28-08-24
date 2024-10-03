package com.example.testtaskeffective_29_08_24.ui.mainfull.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskeffective_29_08_24.databinding.ItemClHeaderBinding
import com.example.testtaskeffective_29_08_24.ui.main.adapter.items.TitleItem
import com.example.testtaskeffective_29_08_24.ui.mainfull.adapter.items.HeaderItem


class HeaderViewHolder(private val binding: ItemClHeaderBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: HeaderItem) {
        binding.tvAmountOfVacancies.text = "${item.vacancyNumber} ${item.vacancyWord}"
    }
}