package com.victorcaveda.marketwatcher.domain.model

import java.time.Instant

data class Price(
    val ticker: String,
    val date: Instant,
    val currentPrice: Double,
    val currency: String
)
