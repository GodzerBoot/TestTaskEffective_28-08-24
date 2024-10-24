package com.example.features.main_screen.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.features.main_screen.databinding.ItemOfferBinding
import com.example.features.main_screen.ui.adapter.item.OfferItem


class OfferAdapter : ListAdapter<OfferItem, OfferViewHolder>(DIFFER) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        return OfferViewHolder(ItemOfferBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFFER = object : DiffUtil.ItemCallback<OfferItem>() {
            override fun areItemsTheSame(
                oldItem: OfferItem,
                newItem: OfferItem
            ): Boolean {
                return false
            }

            override fun areContentsTheSame(
                oldItem: OfferItem,
                newItem: OfferItem
            ): Boolean {
                return false
            }

        }
    }
}