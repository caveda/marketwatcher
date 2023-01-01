package com.victorcaveda.marketwatcher.data.repository

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


@OptIn(ExperimentalCoroutinesApi::class)
class CryptoRepositoryImplTest {

    @Test
    fun `Given the crypto ABC When getting the current price Then 9999 is returned`() = runTest {
        val actual = CryptoRepositoryImpl().getCryptoPrice("ABC")

        assertEquals(actual.getOrNull()?.currentPrice, 9999.0)
    }
}