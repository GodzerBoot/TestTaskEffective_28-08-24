package com.example.testtaskeffective_29_08_24

import com.google.gson.annotations.SerializedName


data class Experience(

    @SerializedName("previewText") val previewText: String?,
    @SerializedName("text") val text: String?,

)