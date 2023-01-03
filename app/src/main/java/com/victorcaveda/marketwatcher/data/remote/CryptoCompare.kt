package com.victorcaveda.marketwatcher.data.remote

import com.victorcaveda.marketwatcher.data.remote.model.SymbolPricesDto

interface CryptoCompare {

    suspend fun getSingleSymbolPrice(symbol: String, currencies: List<String>): SymbolPricesDto?

}