package com.example.testtaskeffective_29_08_24

import com.example.testtaskeffective_29_08_24.data.OfferButton
import com.google.gson.annotations.SerializedName


data class Offer(

    @SerializedName("id") var id: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("button") var button: OfferButton? = null,
    @SerializedName("link") var link: String? = null

)