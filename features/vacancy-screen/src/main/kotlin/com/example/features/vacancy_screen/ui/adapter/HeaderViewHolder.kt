package com.example.features.vacancy_screen.ui.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.features.vacancy_screen.ui.adapter.item.HeaderItem
import com.example.features.vacancy_screen.databinding.ItemHeaderBinding

class HeaderViewHolder(private val binding: ItemHeaderBinding) : ViewHolder(binding.root) {
    fun bind(item: HeaderItem) {
        binding.tvTitle.text = item.title
        binding.tvSalary.text = item.salary
        binding.tvExperience.text = item.experience
        binding.tvEmploymentType.text = employmentType(item.employmentType)
    }

    private fun employmentType(string: String): String {
        return string.replace("[", "").replace("]", "").replaceFirstChar { it.uppercase() }
    }
}