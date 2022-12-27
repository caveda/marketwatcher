package com.victorcaveda.marketwatcher.domain.repository

import com.victorcaveda.marketwatcher.domain.model.Price

interface CryptoRepository {
    suspend fun getCryptoPrice(id: String): Result<Price>
}