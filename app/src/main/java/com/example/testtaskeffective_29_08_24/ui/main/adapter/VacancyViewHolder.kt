package com.example.testtaskeffective_29_08_24.ui.main.adapter

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskeffective_29_08_24.databinding.ItemVacancyBoxBinding
import com.example.testtaskeffective_29_08_24.ui.main.adapter.items.VacancyItem

class VacancyViewHolder(
    private val binding: ItemVacancyBoxBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: VacancyItem) {
        binding.vacancyLookingNumber.text = item.lookingNumber
        binding.vacancyLookingNumber.isVisible = item.isVisibleLookingNumber
        binding.vacancyTitle.text = item.title
        binding.vacancyTitle.isVisible = item.isVisibleTitle
        binding.vacancySalary.text = item.salary
        binding.vacancySalary.isVisible = item.isVisibleSalary
        binding.vacancySubtableTown.text = item.town
        binding.vacancySubtableTown.isVisible = item.isVisibleTown
        binding.vacancySubtableCompany.text = item.company
        binding.vacancySubtableCompany.isVisible = item.isVisibleCompany
        binding.vacancyExperience.text = item.experience
        binding.vacancyExperience.isVisible = item.isVisibleExperience
        binding.vacancyPublishedDate.text = item.publishedDate
        binding.vacancyPublishedDate.isVisible = item.isVisiblePublishedDate
    }
}