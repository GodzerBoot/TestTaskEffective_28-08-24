package com.example.testtaskeffective_29_08_24.ui.main.adapter

import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskeffective_29_08_24.ui.main.VacancyItem
import com.example.testtaskeffective_29_08_24.databinding.ItemVacancyBoxBinding

class VacancyViewHolder(
    private val binding: ItemVacancyBoxBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: VacancyItem) {

        binding.vacancyLookingNumber.text = item.vacancyLookingNumber
        binding.vacancyLookingNumber.isVisible = item.vacancyLookingNumber.isNotEmpty()
        binding.vacancyTitle.text = item.vacancyTitle
        binding.vacancyTitle.isVisible = item.vacancyTitle.isNotEmpty()
        binding.vacancySalary.text = item.vacancySalary
        binding.vacancySalary.isVisible = item.vacancySalary.isNotEmpty()
        binding.vacancySubtableTown.text = item.vacancySubtableTown
        binding.vacancySubtableTown.isVisible = item.vacancySubtableTown.isNotEmpty()
        binding.vacancySubtableCompany.text = item.vacancySubtableCompany
        binding.vacancySubtableCompany.isVisible = item.vacancySubtableCompany.isNotEmpty()
        binding.vacancyExperience.text = item.vacancyExperience
        binding.vacancyExperience.isVisible = item.vacancyExperience.isNotEmpty()
        binding.vacancyPublishedDate.text = item.vacancyPublishedDate
        binding.vacancyPublishedDate.isVisible = item.vacancyPublishedDate.isNotEmpty()

    }

    companion object {
        val DIFFABLE = object : DiffUtil.ItemCallback<VacancyItem>() {
            override fun areItemsTheSame(
                oldItem: VacancyItem,
                newItem: VacancyItem
            ): Boolean {
                return false
            }

            override fun areContentsTheSame(
                oldItem: VacancyItem,
                newItem: VacancyItem
            ): Boolean {
                return false
            }

        }
    }
}