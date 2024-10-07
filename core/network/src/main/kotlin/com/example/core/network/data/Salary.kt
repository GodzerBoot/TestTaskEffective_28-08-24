package com.example.testtaskeffective_29_08_24

import com.google.gson.annotations.SerializedName


data class Salary(

    @SerializedName("short") val short: String?,
    @SerializedName("full") val full: String?,

)