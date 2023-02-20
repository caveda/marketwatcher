package com.victorcaveda.marketwatcher.presentation.home

import com.victorcaveda.marketwatcher.presentation.model.AssetPriceData
import com.victorcaveda.marketwatcher.presentation.model.AssetsScreenData

object SampleAssetPriceData {
    val value = AssetsScreenData(
        listOf(
            AssetPriceData("AMZN", "Amazon", "100,32 EUR"),
            AssetPriceData("KO", "CocaCola", "13,13 EUR"),
            AssetPriceData("IBM", "IBM", "135,23 EUR"),
            AssetPriceData("MCD", "McDonald's", "268,33 EUR"),
            AssetPriceData("GILD", "Gilead Sciences", "84,76 EUR"),
            AssetPriceData("AAPL", "Apple", "152,47 EUR"),
            AssetPriceData("T", "AT&T", "15,45 EUR"),
            AssetPriceData("MSFT", "Microsoft", "258,31 EUR"),
            AssetPriceData("INTC", "Intel", "27,88 EUR"),
            AssetPriceData("JNJ", "Johnson & Johnson ", "160,55 EUR"),
            AssetPriceData("GOOG", "Alphabet inc", "92,73 EUR"),
            AssetPriceData("CSCO", "Cisco Systems", "50,77 EUR"),
            AssetPriceData("DIS", "The Walt Disney co", "140,13 EUR"),
            AssetPriceData("VZ", "Verizon", "40,98 EUR"),
            AssetPriceData("PG", "Procter & Gamble", "140,01 EUR"),
            AssetPriceData("NVDA", "NVIDIA Corporation", "213,88 EUR"),
        )
    )
}

