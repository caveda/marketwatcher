package com.victorcaveda.marketwatcher.data.repository

import com.victorcaveda.marketwatcher.data.remote.CryptoCompare
import com.victorcaveda.marketwatcher.data.remote.model.SymbolCryptoDto
import com.victorcaveda.marketwatcher.data.remote.model.SymbolSinglePrice
import com.victorcaveda.marketwatcher.domain.model.Price
import com.victorcaveda.marketwatcher.domain.repository.CryptoRepository
import java.time.Instant
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val cryptoDataSource: CryptoCompare
) : CryptoRepository {

    override suspend fun getCryptoPrice(ticker: String, currency: String): Result<Price> {
        val price = cryptoDataSource.getSingleSymbolPrice(ticker, listOf(currency))
        price?.let {
            return Result.success(it.toDomain(ticker))
        }
        return Result.failure(Exception("Something bad happened"))
    }
}

fun SymbolSinglePrice.toDomain(ticker: String) =
    Price(ticker, Instant.now(), price, currency)

fun SymbolCryptoDto.toDomain(ticker: String) =
    Price(ticker, Instant.now(), euro, "EUR")
