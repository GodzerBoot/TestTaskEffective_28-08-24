package com.example.features.main_screen.ui.adapter

import android.view.View.OnClickListener
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.features.main_screen.databinding.ItemBtnMoreBinding
import com.example.features.main_screen.ui.adapter.items.ButtonMoreItem


class ButtonMoreViewHolder(
    private val binding: ItemBtnMoreBinding,
    private val callback: ButtonMoreCallback,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ButtonMoreItem) {
        setupVisibility(item)
        setupText(item)
        setupClickListener()
    }

    private fun setupVisibility(item: ButtonMoreItem) {
        if (item.quantityOfVacancies <= 0) binding.btnMoreMain.isVisible = false
    }

    private fun setupText(item: ButtonMoreItem) {
        binding.btnMoreMain.text = "Ещё ${item.quantityOfVacancies} ${item.vacancyWord}"
    }

    private fun setupClickListener() {
        binding.btnMoreMain.setOnClickListener { callback.onClick() }
    }

    interface ButtonMoreCallback {
        fun onClick()
    }
}