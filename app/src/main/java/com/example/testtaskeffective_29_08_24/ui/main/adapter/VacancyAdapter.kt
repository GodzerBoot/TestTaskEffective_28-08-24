package com.example.testtaskeffective_29_08_24.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.testtaskeffective_29_08_24.R
import com.example.testtaskeffective_29_08_24.databinding.ItemTitleBinding
import com.example.testtaskeffective_29_08_24.ui.main.VacancyItem
import com.example.testtaskeffective_29_08_24.databinding.ItemVacancyBoxBinding

class VacancyAdapter : ListAdapter<VacancyItem, ViewHolder>(VacancyViewHolder.DIFFABLE) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            0 -> TitleViewHolder(ItemTitleBinding.inflate(LayoutInflater.from(parent.context)).mainTitle)
            else -> VacancyViewHolder(ItemVacancyBoxBinding.inflate(LayoutInflater.from(parent.context)))
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder.itemView.id) {
            R.id.main_title -> {}
            R.id.main_vacancy_offer -> {
                val mHolder = holder as VacancyViewHolder
                mHolder.bind(getItem(position - 1))
            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> 0
            else -> 1
        }
    }


}