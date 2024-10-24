package com.example.features.vacancy_screen.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.features.vacancy_screen.ui.adapter.item.ApplyItem
import com.example.features.vacancy_screen.ui.adapter.item.DescriptionItem
import com.example.features.vacancy_screen.ui.adapter.item.HeaderItem
import com.example.features.vacancy_screen.ui.adapter.item.LocationItem
import com.example.features.vacancy_screen.ui.adapter.item.OthersItem
import com.example.features.vacancy_screen.ui.adapter.item.QuestionsItem
import com.example.features.vacancy_screen.ui.adapter.item.ResponsibilitiesItem
import com.example.features.vacancy_screen.databinding.ItemApplyBinding
import com.example.features.vacancy_screen.databinding.ItemDescriptionBinding
import com.example.features.vacancy_screen.databinding.ItemHeaderBinding
import com.example.features.vacancy_screen.databinding.ItemLocationBinding
import com.example.features.vacancy_screen.databinding.ItemOthersBinding
import com.example.features.vacancy_screen.databinding.ItemQuestionsBinding
import com.example.features.vacancy_screen.databinding.ItemResponsibilitiesBinding

class VacancyScreenAdapter : ListAdapter<Any, RecyclerView.ViewHolder>(DIFFER) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0x01 -> HeaderViewHolder(ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            0x02 -> OthersViewHolder(ItemOthersBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            0x03 -> LocationViewHolder(ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            0x04 -> DescriptionViewHolder(ItemDescriptionBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            0x05 -> ResponsibilitiesViewHolder(ItemResponsibilitiesBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            0x06 -> QuestionsViewHolder(ItemQuestionsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            0x07 -> ApplyViewHolder(ItemApplyBinding.inflate(LayoutInflater.from(parent.context), parent, false))

            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is HeaderItem -> {
                val viewHolder = holder as HeaderViewHolder
                viewHolder.bind(item)
            }

            is OthersItem -> {
                val viewHolder = holder as OthersViewHolder
                viewHolder.bind(item)
            }

            is LocationItem -> {
                val viewHolder = holder as LocationViewHolder
                viewHolder.bind(item)
            }

            is DescriptionItem -> {
                val viewHolder = holder as DescriptionViewHolder
                viewHolder.bind(item)
            }
            is ResponsibilitiesItem -> {
                val viewHolder = holder as ResponsibilitiesViewHolder
                viewHolder.bind(item)
            }
            is QuestionsItem -> {
                val viewHolder = holder as QuestionsViewHolder
                viewHolder.bind(item)
            }
            is ApplyItem -> {
                val viewHolder = holder as ApplyViewHolder
                viewHolder.bind(item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is HeaderItem -> 0x01
            is OthersItem -> 0x02
            is LocationItem -> 0x03
            is DescriptionItem -> 0x04
            is ResponsibilitiesItem -> 0x05
            is QuestionsItem -> 0x06
            is ApplyItem -> 0x07
            else -> throw IllegalArgumentException("no such item")
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