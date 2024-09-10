package com.example.testtaskeffective_29_08_24.ui.main.adapter

import android.annotation.SuppressLint
import android.content.res.Resources
import android.util.Size
import android.util.TypedValue
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskeffective_29_08_24.R

@SuppressLint("ResourceAsColor")
class TitleViewHolder(textView: TextView) : RecyclerView.ViewHolder(textView) {
    init {
        textView.text = "Title"
        textView.setTextAppearance(R.style.title_1)
        textView.setTextColor(R.color.white)
        textView.textSize = 24F
    }
}