package com.victorcaveda.marketwatcher.presentation.model

import androidx.annotation.DrawableRes
import com.victorcaveda.marketwatcher.R
import kotlin.random.Random

data class TradeData(
    val ticker: String,
    val name: String,
    val price: String,
    val priceChangePercent: Double,
    @DrawableRes val companyLogo: Int = pickRandomCompanyLogo()
)

private fun pickRandomCompanyLogo(): Int =
    when (Random(System.currentTimeMillis()).nextInt(0, 4)) {
        0 -> R.drawable.apple
        1 -> R.drawable.mastercard
        2 -> R.drawable.nike
        else -> R.drawable.visa
    }

data class Fundamentals(
    val per: String,
    val dividendYield: String,
    val ratioDebtEbitda: String,
    val earningsPerShare: String
)

