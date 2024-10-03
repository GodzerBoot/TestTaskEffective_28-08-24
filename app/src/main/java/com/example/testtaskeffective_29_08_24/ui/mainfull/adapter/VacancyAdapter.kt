package com.example.testtaskeffective_29_08_24.ui.mainfull.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.testtaskeffective_29_08_24.databinding.ItemClHeaderBinding
import com.example.testtaskeffective_29_08_24.databinding.ItemVacancyBoxBinding
import com.example.testtaskeffective_29_08_24.ui.mainfull.adapter.items.HeaderItem
import com.example.testtaskeffective_29_08_24.ui.mainfull.adapter.items.VacancyItem

class VacancyAdapter : ListAdapter<Any, ViewHolder>(DIFFER) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            0x01 -> HeaderViewHolder(ItemClHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            0x02 -> VacancyViewHolder(ItemVacancyBoxBinding.inflate(LayoutInflater.from(parent.context)))
            else -> throw IllegalArgumentException()
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is HeaderItem -> {
                val viewHolder = holder as HeaderViewHolder
                viewHolder.bind(item)
            }
            is VacancyItem -> {
                val viewHolder = holder as VacancyViewHolder
                viewHolder.bind(item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is HeaderItem -> 0x01
            is VacancyItem -> 0x02
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