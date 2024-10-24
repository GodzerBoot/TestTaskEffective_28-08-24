package com.example.features.main_screen.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.features.main_screen.databinding.ItemRvOffersBinding
import com.example.features.main_screen.ui.adapter.item.OfferItem
import com.example.features.main_screen.ui.adapter.item.OffersItem


class OffersViewHolder(private val binding: ItemRvOffersBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: OffersItem, offers: List<OfferItem>) {
        val adapter = OfferAdapter()
        adapter.submitList(offers)
        binding.rvOffers.adapter = adapter
    }
}