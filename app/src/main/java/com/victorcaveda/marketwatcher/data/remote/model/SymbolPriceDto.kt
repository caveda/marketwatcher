package com.victorcaveda.marketwatcher.data.remote.model


data class SymbolPricesDto(
    val prices: List<SymbolSinglePrice>
)


data class SymbolSinglePrice(
    val currency: String,
    val price: Double
)
