package com.example.features.local_database.entities

import android.view.View.OnClickListener
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("vacancy")
data class VacancyEntity(
    @PrimaryKey val id: String,
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
    val isFavourite: Boolean,
    val onClickListenerToVacancy: OnClickListener,
//    val onClickListenerFavorite: (Any) -> Unit
    )