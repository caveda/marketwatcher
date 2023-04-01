package com.victorcaveda.marketwatcher.presentation.home

import com.victorcaveda.marketwatcher.presentation.model.AssetViewData
import com.victorcaveda.marketwatcher.presentation.model.AssetsScreenData
import com.victorcaveda.marketwatcher.presentation.model.Fundamentals
import com.victorcaveda.marketwatcher.presentation.model.TradeData

object SampleAssetPriceData {


    private val prices =
        listOf(
            TradeData("AMZN", "Amazon", "100.32 EUR", -3.54),
            TradeData("KO", "CocaCola", "13.13 EUR", 0.99),
            TradeData("IBM", "IBM", "135.23 EUR", 5.41),
            TradeData("MCD", "McDonald's", "268.33 EUR", -2.43),
            TradeData("GILD", "Gilead Sciences", "84.76 EUR", -0.22),
            TradeData("AAPL", "Apple", "152.47 EUR", 1.32),
            TradeData("T", "AT&T", "15.45 EUR", 2.33),
            TradeData("MSFT", "Microsoft", "258.31 EUR", -7.20),
            TradeData("INTC", "Intel", "27.88 EUR", 0.01),
            TradeData("JNJ", "Johnson & Johnson ", "160.55 EUR", 2.22),
            TradeData("GOOG", "Alphabet inc", "92.73 EUR", 1.44),
            TradeData("CSCO", "Cisco Systems", "50.77 EUR", 10.33),
            TradeData("DIS", "The Walt Disney co", "140.13 EUR", -1.20),
            TradeData("VZ", "Verizon", "40.98 EUR", 0.22),
            TradeData("PG", "Procter & Gamble", "140.01 EUR", 3.76),
            TradeData("NVDA", "NVIDIA Corporation", "21.88 EUR", -4.59),
        )


    val fundamentals = Fundamentals(
        per = "15.5",
        dividendYield = "4.5%",
        earningsPerShare = "5 EUR",
        ratioDebtEbitda = "2.1"
    )

    val value = AssetsScreenData(prices.map { AssetViewData(it, fundamentals) })
}


