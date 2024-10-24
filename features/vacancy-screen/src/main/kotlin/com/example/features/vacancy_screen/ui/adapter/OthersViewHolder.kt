package com.example.features.vacancy_screen.ui.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.features.vacancy_screen.databinding.ItemOthersBinding
import com.example.features.vacancy_screen.ui.adapter.item.OthersItem

class OthersViewHolder(private val binding: ItemOthersBinding) : ViewHolder(binding.root) {
    fun bind(item: OthersItem) {
        binding.tvResponded.text = appliedText(item.appliedNumber)
        binding.tvWatching.text = lookingText(item.lookingNumber)
    }

    private fun appliedText(number: Int): String {
        return when(number%10) {
            1 -> "$number человек уже откликнулся"
            2, 3, 4 -> "$number человека уже откликнулось"
            else -> "$number человек уже откликнулось"
        }
    }
    private fun lookingText(number: Int): String {
        return when(number%10) {
            1 -> "$number человек сейчас смотрит"
            2, 3, 4 -> "$number человека сейчас смотрят"
            else -> "$number человек сейчас смотрят"
        }
    }
}