package com.example.testtaskeffective_29_08_24.ui.main.adapter

import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskeffective_29_08_24.R
import com.example.testtaskeffective_29_08_24.databinding.ItemOfferBinding
import com.example.testtaskeffective_29_08_24.domain.vacancies.Offer
import com.example.testtaskeffective_29_08_24.ui.main.adapter.items.OfferItem
import java.lang.IllegalArgumentException

class OfferViewHolder(private val binding: ItemOfferBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: OfferItem) {
        setupOfferIcon(item)
        binding.tvOfferTitle.text = item.title
        binding.tvOfferTitle.maxLines = item.titleLines
        binding.tvOfferButton.text = item.buttonText
        binding.tvOfferButton.isVisible = item.isVisibleButton
    }

    private fun setupOfferIcon(item: OfferItem) {
        if (item.type == Offer.OfferType.UNDEFINED) {
            binding.ivOfferIcon.isVisible = false
            binding.llOfferIconBg.isVisible = false
            return
        }
        binding.ivOfferIcon.isVisible = true
        binding.llOfferIconBg.isVisible = true
        binding.ivOfferIcon.setImageResource(getOfferIconId(item.type))
        binding.llOfferIconBg.backgroundTintList = getOfferIconBackgroundTintColor(item.type)
    }

    private fun getOfferIconId(type: Offer.OfferType): Int {
        return when (type) {
            Offer.OfferType.NEAR_VACANCIES -> R.drawable.pin_drop
            Offer.OfferType.LEVEL_UP_RESUME -> R.drawable.level_up_resume_icon
            Offer.OfferType.TEMPORARY_JOB -> R.drawable.temporary_job_icon
            else -> throw IllegalArgumentException("offerIconId")
        }
    }

    private fun getOfferIconBackgroundTintColor(type: Offer.OfferType): ColorStateList {
        val color = when (type) {
            Offer.OfferType.NEAR_VACANCIES -> R.color.dark_blue
            Offer.OfferType.LEVEL_UP_RESUME -> R.color.dark_green
            Offer.OfferType.TEMPORARY_JOB -> R.color.dark_green
            else -> throw IllegalArgumentException("offerIconBackground")
        }
        return ColorStateList.valueOf(ContextCompat.getColor(binding.root.context, color))
    }
}