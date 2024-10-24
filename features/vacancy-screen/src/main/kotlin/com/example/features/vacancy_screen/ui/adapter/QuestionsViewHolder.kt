package com.example.features.vacancy_screen.ui.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.features.vacancy_screen.ui.adapter.item.QuestionsItem
import com.example.features.vacancy_screen.databinding.ItemQuestionsBinding

class QuestionsViewHolder(private val binding: ItemQuestionsBinding) : ViewHolder(binding.root) {
    fun bind(item: QuestionsItem) {
        val adapter = QuestionsAdapter()
        adapter.submitList(item.questionItems)
        binding.rvQuestions.adapter = adapter

    }
}