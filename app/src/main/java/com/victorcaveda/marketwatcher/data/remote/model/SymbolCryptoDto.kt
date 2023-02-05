package com.victorcaveda.marketwatcher.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SymbolCryptoDto(
    @Json(name = "EUR")
    val euro: Double
//    @Json(name = "USD")
//    val dollar: Double
)