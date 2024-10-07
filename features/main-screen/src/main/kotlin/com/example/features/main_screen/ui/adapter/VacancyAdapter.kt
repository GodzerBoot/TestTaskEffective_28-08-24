package com.example.features.main_screen.ui.adapter

import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.features.main_screen.databinding.ItemBtnMoreBinding
import com.example.features.main_screen.databinding.ItemClHeaderBinding
import com.example.features.main_screen.databinding.ItemRvOffersBinding
import com.example.features.main_screen.databinding.ItemTitleBinding
import com.example.features.main_screen.databinding.ItemVacancyBoxBinding
import com.example.features.main_screen.ui.adapter.items.ButtonMoreItem
import com.example.features.main_screen.ui.adapter.items.HeaderItem
import com.example.features.main_screen.ui.adapter.items.OfferItem
import com.example.features.main_screen.ui.adapter.items.OffersItem
import com.example.features.main_screen.ui.adapter.items.TitleItem
import com.example.features.main_screen.ui.adapter.items.VacancyItem


class VacancyAdapter(
    private val callback: ButtonMoreViewHolder.ButtonMoreCallback,
) : ListAdapter<Any, RecyclerView.ViewHolder>(DIFFER) {
    var offers: List<OfferItem> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0x01 -> TitleViewHolder(ItemTitleBinding.inflate(LayoutInflater.from(parent.context)))
            0x02 -> VacancyViewHolder(ItemVacancyBoxBinding.inflate(LayoutInflater.from(parent.context)))
            0x03 -> OffersViewHolder(ItemRvOffersBinding.inflate(LayoutInflater.from(parent.context)))
            0x04 -> ButtonMoreViewHolder(
                ItemBtnMoreBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ), callback
            )
            0x05 -> HeaderViewHolder(ItemClHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false))

            else -> throw IllegalArgumentException()
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is TitleItem -> {
                val viewHolder = holder as TitleViewHolder
                viewHolder.bind(item)
            }

            is VacancyItem -> {
                val viewHolder = holder as VacancyViewHolder
                viewHolder.bind(item)
            }

            is OffersItem -> {
                val viewHolder = holder as OffersViewHolder
                viewHolder.bind(item, offers)
            }

            is ButtonMoreItem -> {
                val viewHolder = holder as ButtonMoreViewHolder
                viewHolder.bind(item)
            }
            is HeaderItem -> {
                val viewHolder = holder as HeaderViewHolder
                viewHolder.bind(item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is TitleItem -> 0x01
            is VacancyItem -> 0x02
            is OffersItem -> 0x03
            is ButtonMoreItem -> 0x04
            is HeaderItem -> 0x05
            else -> throw IllegalArgumentException()
        }
    }

    companion object {
        val DIFFER = object : DiffUtil.ItemCallback<Any>() {
            override fun areItemsTheSame(
                oldItem: Any,
                newItem: Any
            ): Boolean {
                return false
            }

            override fun areContentsTheSame(
                oldItem: Any,
                newItem: Any
            ): Boolean {
                return false
            }

        }
    }

}