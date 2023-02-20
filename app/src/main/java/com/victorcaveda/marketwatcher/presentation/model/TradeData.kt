package com.victorcaveda.marketwatcher.presentation.model

data class TradeData(
    val ticker: String,
    val name: String,
    val price: String
)

data class Fundamentals(
    val per: String,
    val dividendYield: String,
    val ratioDebtEbitda: String,
    val earningsPerShare: String
)

