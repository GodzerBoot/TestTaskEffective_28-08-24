package com.example.features.main_screen.ui

import com.example.features.main_screen.ui.adapter.item.OfferItem

data class MainScreenUiState (
    val vacancies: List<Any>,
    val offers: List<OfferItem>,
)