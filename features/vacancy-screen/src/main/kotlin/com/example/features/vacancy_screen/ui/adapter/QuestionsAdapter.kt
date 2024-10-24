package com.example.features.vacancy_screen.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.features.vacancy_screen.ui.adapter.item.QuestionItem
import com.example.features.vacancy_screen.databinding.ItemQuestionBinding

class QuestionsAdapter : ListAdapter<QuestionItem, QuestionViewHolder>(DIFFER) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        return QuestionViewHolder(ItemQuestionBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFFER = object : DiffUtil.ItemCallback<QuestionItem>() {
            override fun areItemsTheSame(oldItem: QuestionItem, newItem: QuestionItem): Boolean {
                return false
            }

            override fun areContentsTheSame(oldItem: QuestionItem, newItem: QuestionItem): Boolean {
                return false
            }

        }
    }
}