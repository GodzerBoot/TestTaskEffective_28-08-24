package com.example.testtaskeffective_29_08_24.ui.main.adapter

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.core.navigation.Screens
import com.example.testtaskeffective_29_08_24.databinding.ItemBtnMoreBinding
import com.example.testtaskeffective_29_08_24.ui.ScreensImpl
import com.example.testtaskeffective_29_08_24.ui.main.adapter.items.ButtonMoreItem
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ButtonMoreViewHolder (private val binding: ItemBtnMoreBinding) : RecyclerView.ViewHolder(binding.root), KoinComponent {
    private val cicerone: Cicerone<Router> by inject()
    private val screens: Screens by inject()
    fun bind(item: ButtonMoreItem) {
        setupVisibility(item)
        setupText(item)
        setupClickListener()
    }

    private fun setupVisibility(item: ButtonMoreItem){
        if(item.quantityOfVacancies <= 0) binding.btnMoreMain.isVisible = false
    }
    private fun setupText(item: ButtonMoreItem){
        binding.btnMoreMain.text = "Ещё ${item.quantityOfVacancies} ${item.vacancyWord}"
    }
    private fun setupClickListener(){
        binding.btnMoreMain.setOnClickListener {
            cicerone.router.navigateTo(screens.mainFull())
        }
    }
}