package com.victorcaveda.marketwatcher.data.repository

import com.victorcaveda.marketwatcher.domain.model.Price
import com.victorcaveda.marketwatcher.domain.repository.CryptoRepository
import kotlinx.coroutines.delay
import java.time.Instant
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor() : CryptoRepository {

    override suspend fun getCryptoPrice(ticker: String): Result<Price> {
        delay(100)
        return Result.success(Price(ticker, Instant.now(), 9999.0, "EUR"))
    }
}