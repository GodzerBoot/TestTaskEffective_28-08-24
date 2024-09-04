package com.example.testtaskeffective_29_08_24.ui.main.adapter

import android.annotation.SuppressLint
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskeffective_29_08_24.ui.main.VacancyItem
import com.example.testtaskeffective_29_08_24.databinding.ItemVacancyBoxBinding
import java.time.Month

class VacancyViewHolder(
    private val binding: ItemVacancyBoxBinding
) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(item: VacancyItem) {

        binding.vacancyLookingNumber.text =
            "Сейчас просматривает " + item.vacancyLookingNumber + " человек"
        binding.vacancyLookingNumber.isVisible = item.vacancyLookingNumber.isNotEmpty()
        binding.vacancyTitle.text = item.vacancyTitle
        binding.vacancyTitle.isVisible = item.vacancyTitle.isNotEmpty()
        binding.vacancySalary.text = item.vacancySalary.replace(" до ", "-")
        binding.vacancySalary.isVisible =
            item.vacancySalary.isNotEmpty() && item.vacancySalary != "Уровень дохода не указан"
        binding.vacancySubtableTown.text = item.vacancySubtableTown
        binding.vacancySubtableTown.isVisible = item.vacancySubtableTown.isNotEmpty()
        binding.vacancySubtableCompany.text = item.vacancySubtableCompany
        binding.vacancySubtableCompany.isVisible = item.vacancySubtableCompany.isNotEmpty()
        binding.vacancyExperience.text = item.vacancyExperience
        binding.vacancyExperience.isVisible = item.vacancyExperience.isNotEmpty()
        binding.vacancyPublishedDate.text =
            "Опубликовано " + item.vacancyPublishedDate.slice(listOf(8, 9)) + " " + getMonth(
                item.vacancyPublishedDate.slice(listOf(5, 6)).toInt()
            )
        binding.vacancyPublishedDate.isVisible =
            item.vacancyPublishedDate.isNotEmpty()

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

private fun getMonth(num: Int): String {
    return when (num) {
        1 -> "Января"
        2 -> "Февраля"
        3 -> "Марта"
        4 -> "Апреля"
        5 -> "Мая"
        6 -> "Июня"
        7 -> "Июля"
        8 -> "Августа"
        9 -> "Сентября"
        10 -> "Октября"
        11 -> "Ноября"
        12 -> "Декабря"
        else -> "ERROR:WRONG_MONTH_INDEX"
    }
}