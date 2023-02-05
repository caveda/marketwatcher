package com.victorcaveda.marketwatcher.data.remote.model


data class AssetsPrices(
    val assets: List<SymbolPricesDto>
)

data class SymbolPricesDto(
    val symbol: String,
    val prices: List<SymbolSinglePrice>
)

data class SymbolSinglePrice(
    val currency: String,
    val price: Double
)


