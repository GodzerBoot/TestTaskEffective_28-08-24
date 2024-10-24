package com.example.features.main_screen.ui.adapter.item

import android.view.View.OnClickListener

data class VacancyItem (
    val lookingNumber: String,
    val isVisibleLookingNumber: Boolean,
    val title: String,
    val isVisibleTitle: Boolean,
    val salary: String,
    val isVisibleSalary: Boolean,
    val town: String,
    val isVisibleTown: Boolean,
    val company: String,
    val isVisibleCompany: Boolean,
    val experience: String,
    val isVisibleExperience: Boolean,
    val publishedDate: String,
    val isVisiblePublishedDate: Boolean,
    val onClickListenerToVacancy: OnClickListener,
)