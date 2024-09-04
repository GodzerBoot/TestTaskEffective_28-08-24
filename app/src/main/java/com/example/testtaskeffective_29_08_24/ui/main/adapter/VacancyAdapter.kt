package com.example.testtaskeffective_29_08_24.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.testtaskeffective_29_08_24.ui.main.VacancyItem
import com.example.testtaskeffective_29_08_24.databinding.ItemVacancyBoxBinding

class VacancyAdapter : ListAdapter<VacancyItem, VacancyViewHolder>(VacancyViewHolder.DIFFABLE) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacancyViewHolder {
        return VacancyViewHolder(ItemVacancyBoxBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: VacancyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}