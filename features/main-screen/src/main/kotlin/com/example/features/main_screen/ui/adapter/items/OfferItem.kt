package com.example.features.main_screen.ui.adapter.items

import com.example.features.main_screen.domain.Offer


data class OfferItem (
    val type: Offer.OfferType,
    val title: String,
    val titleLines: Int,
    val buttonText: String,
    val isVisibleButton: Boolean,
    val link: String,
)