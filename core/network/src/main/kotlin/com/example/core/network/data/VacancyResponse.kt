package com.example.core.network.data

import com.google.gson.annotations.SerializedName


data class VacancyResponse(

    @SerializedName("id") val id: String?,
    @SerializedName("lookingNumber") val lookingNumber: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("address") val address: Address?,
    @SerializedName("company") val company: String?,
    @SerializedName("experience") val experience: Experience?,
    @SerializedName("publishedDate") val publishedDate: String?,
    @SerializedName("isFavorite") val isFavorite: Boolean,
    @SerializedName("salary") val salary: Salary?,
    @SerializedName("schedules") val schedules: ArrayList<String>,
    @SerializedName("appliedNumber") val appliedNumber: Int?,
    @SerializedName("description") val description: String?,
    @SerializedName("responsibilities") val responsibilities: String?,
    @SerializedName("questions") val questions: ArrayList<String>,

    )