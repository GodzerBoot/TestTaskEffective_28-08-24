package com.example.testtaskeffective_29_08_24.ui.main.adapter

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskeffective_29_08_24.databinding.ItemOfferBinding
import com.example.testtaskeffective_29_08_24.ui.main.adapter.items.OfferItem

class OfferViewHolder(private val binding: ItemOfferBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: OfferItem) {
        binding.ivOfferIcon.setImageResource(item.drawableId)
        binding.ivOfferIcon.isVisible = item.isVisibleIcon
        binding.llOfferIconBg.isVisible = item.isVisibleIcon
        binding.tvOfferTitle.text = item.title
        binding.tvOfferTitle.maxLines = item.titleLines
        binding.tvOfferButton.text = item.buttonText
        binding.tvOfferButton.isVisible = item.isVisibleButton
    }
}