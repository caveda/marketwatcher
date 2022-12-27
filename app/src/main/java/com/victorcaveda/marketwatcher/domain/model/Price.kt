package com.victorcaveda.marketwatcher.domain.model

import java.time.Instant

data class Price(
    val date: Instant,
    val currentPrice: Double,
    val currency: String
)
