package com.victorcaveda.marketwatcher.data.remote

import com.victorcaveda.marketwatcher.data.remote.model.SymbolCryptoDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoCompare {
    @GET("data/price")
    suspend fun getSingleSymbolPrice(@Query("fsym") symbol: String, @Query("tsyms") currencies: List<String>): SymbolCryptoDto?
}