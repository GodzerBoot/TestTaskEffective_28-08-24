package com.example.features.main_screen.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.features.main_screen.databinding.ItemTitleBinding
import com.example.features.main_screen.ui.adapter.item.TitleItem


class TitleViewHolder(private val binding: ItemTitleBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TitleItem) {}
}