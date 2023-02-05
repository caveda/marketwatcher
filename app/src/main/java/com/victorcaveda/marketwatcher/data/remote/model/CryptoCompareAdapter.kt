package com.victorcaveda.marketwatcher.data.remote.model

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException

class CryptoCompareAdapter {

    @FromJson
    fun fromJson(symbolPrice: String): AssetsPrices {
        if (symbolPrice.length != 2) throw JsonDataException("Unknown card: $symbolPrice")
        return AssetsPrices(listOf())
    }
}