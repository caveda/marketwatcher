package com.victorcaveda.marketwatcher.data.remote.fake

import com.victorcaveda.marketwatcher.data.remote.CryptoCompare
import com.victorcaveda.marketwatcher.data.remote.model.SymbolPricesDto
import com.victorcaveda.marketwatcher.data.remote.model.SymbolSinglePrice
import java.math.RoundingMode
import javax.inject.Inject
import kotlin.random.Random

class CryptoCompareFakeImpl @Inject constructor() : CryptoCompare {

    override suspend fun getSingleSymbolPrice(
        symbol: String,
        currencies: List<String>
    ): SymbolPricesDto = SymbolPricesDto(currencies.map { generateRandomPrice(it) })


    private fun generateRandomPrice(currency: String): SymbolSinglePrice =
        SymbolSinglePrice(currency, roundPriceBySECRule612(Random.nextDouble(0.0, 1000.0)))


    private fun roundPriceBySECRule612(price: Double): Double {
        if (price < 1.0)
            return roundPrice(price, 5)
        return roundPrice(price, 2)
    }

    private fun roundPrice(price: Double, decimals: Int) =
        price.toBigDecimal().setScale(decimals, RoundingMode.HALF_EVEN).toDouble()
}