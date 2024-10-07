package com.example.testtaskeffective_29_08_24

import com.example.core.network.data.OfferButton
import com.google.gson.annotations.SerializedName


data class OfferResponse(

    @SerializedName("id") val id: String?,
    @SerializedName("title") val title: String,
    @SerializedName("button") val button: OfferButton?,
    @SerializedName("link") val link: String,

    )