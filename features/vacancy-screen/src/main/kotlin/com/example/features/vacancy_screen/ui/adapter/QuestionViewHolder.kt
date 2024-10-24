package com.example.features.vacancy_screen.ui.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.features.vacancy_screen.ui.adapter.item.QuestionItem
import com.example.features.vacancy_screen.databinding.ItemQuestionBinding

class QuestionViewHolder(private val binding: ItemQuestionBinding) : ViewHolder(binding.root) {
    fun bind(item: QuestionItem) {
        binding.tvQuestion.text = item.question
    }
}