package com.example.testtaskeffective_29_08_24.ui.main.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskeffective_29_08_24.databinding.ItemRvOffersBinding
import com.example.testtaskeffective_29_08_24.ui.main.adapter.items.OfferItem
import com.example.testtaskeffective_29_08_24.ui.main.adapter.items.OffersItem

class OffersViewHolder(private val binding: ItemRvOffersBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: OffersItem, offers: List<OfferItem>) {
        val adapter = OfferAdapter()
        adapter.submitList(offers)
        binding.rvOffers.adapter = adapter
    }
}