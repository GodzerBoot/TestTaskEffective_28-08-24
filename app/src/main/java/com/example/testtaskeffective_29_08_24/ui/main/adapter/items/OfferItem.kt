package com.example.testtaskeffective_29_08_24.ui.main.adapter.items

import com.example.testtaskeffective_29_08_24.domain.vacancies.Offer

data class OfferItem (
    val type: Offer.OfferType,
    val title: String,
    val titleLines: Int,
    val buttonText: String,
    val isVisibleButton: Boolean,
    val link: String,
)