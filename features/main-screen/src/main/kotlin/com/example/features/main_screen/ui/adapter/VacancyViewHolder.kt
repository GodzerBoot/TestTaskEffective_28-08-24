package com.example.features.main_screen.ui.adapter

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.features.main_screen.R
import com.example.features.main_screen.databinding.ItemVacancyBoxBinding
import com.example.features.main_screen.ui.adapter.item.VacancyItem


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
        binding.mainVacancyOffer.setOnClickListener(item.onClickListenerToVacancy)
        if (item.isFavourite) {
            binding.vacancyFavoriteIcon.setImageResource(R.drawable.heart_blue)
        } else {
            binding.vacancyFavoriteIcon.setImageResource(R.drawable.nav_favourite_icon)
        }

    }
}