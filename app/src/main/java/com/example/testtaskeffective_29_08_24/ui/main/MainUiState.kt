package com.example.testtaskeffective_29_08_24.ui.main

import com.example.testtaskeffective_29_08_24.ui.main.adapter.items.OfferItem

data class MainUiState(
    val vacancies: List<Any>,
    val offers: List<OfferItem>,
)