package com.victorcaveda.marketwatcher.presentation.model

data class AssetsScreenData(
    val assets: List<AssetViewData>
)

data class AssetViewData(
    val tradeInfo: TradeData,
    val fundamentals: Fundamentals
)
