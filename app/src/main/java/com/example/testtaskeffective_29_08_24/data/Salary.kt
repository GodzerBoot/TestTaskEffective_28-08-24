package com.example.testtaskeffective_29_08_24

import com.google.gson.annotations.SerializedName


data class Salary(

    @SerializedName("short") var short: String? = null,
    @SerializedName("full") var full: String? = null

)