package com.example.core.network.data

import com.google.gson.annotations.SerializedName


data class Experience(

    @SerializedName("previewText") val previewText: String?,
    @SerializedName("text") val text: String?,

)