package com.victorcaveda.marketwatcher.data.repository

import com.victorcaveda.marketwatcher.data.remote.CryptoCompare
import com.victorcaveda.marketwatcher.data.remote.model.SymbolPricesDto
import com.victorcaveda.marketwatcher.data.remote.model.SymbolSinglePrice
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


@OptIn(ExperimentalCoroutinesApi::class)
class CryptoRepositoryImplTest {

    private val cryptoDataSourceDouble = mockk<CryptoCompare>(relaxed = true)
    private lateinit var sut: CryptoRepositoryImpl

    @BeforeEach
    fun setup() {
        sut = CryptoRepositoryImpl(cryptoDataSourceDouble)
    }

    @Test
    fun `Given the crypto ABC When getting the current price Then the current price is returned`() = runTest {
        val currency = "EUR"
        val symbol = "ABC"
        val currentPrice = 9999.0
        coEvery {
            cryptoDataSourceDouble.getSingleSymbolPrice(symbol, listOf(currency))
        } returns buildSymbolPricesResponse(currency, currentPrice)

        val actual = sut.getCryptoPrice(symbol, currency)

        assertEquals(actual.getOrNull()?.currentPrice, currentPrice)
    }

    private fun buildSymbolPricesResponse(currency: String, currentPrice: Double) =
        SymbolPricesDto(listOf(SymbolSinglePrice(currency, currentPrice)))
}
