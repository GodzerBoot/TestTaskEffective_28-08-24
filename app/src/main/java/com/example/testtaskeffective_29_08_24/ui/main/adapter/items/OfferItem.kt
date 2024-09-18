package com.example.testtaskeffective_29_08_24.ui.main.adapter.items

data class OfferItem (
    val drawableId: Int,
    val iconBackgroundColorId: Int,
    val isVisibleIcon: Boolean,
    val title: String,
    val titleLines: Int,
    val buttonText: String,
    val isVisibleButton: Boolean,
    val link: String,
)