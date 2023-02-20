package com.victorcaveda.marketwatcher.presentation.home

import com.victorcaveda.marketwatcher.presentation.model.AssetViewData
import com.victorcaveda.marketwatcher.presentation.model.AssetsScreenData
import com.victorcaveda.marketwatcher.presentation.model.Fundamentals
import com.victorcaveda.marketwatcher.presentation.model.TradeData

object SampleAssetPriceData {


    private val prices =
        listOf(
            TradeData("AMZN", "Amazon", "100,32 EUR"),
            TradeData("KO", "CocaCola", "13,13 EUR"),
            TradeData("IBM", "IBM", "135,23 EUR"),
            TradeData("MCD", "McDonald's", "268,33 EUR"),
            TradeData("GILD", "Gilead Sciences", "84,76 EUR"),
            TradeData("AAPL", "Apple", "152,47 EUR"),
            TradeData("T", "AT&T", "15,45 EUR"),
            TradeData("MSFT", "Microsoft", "258,31 EUR"),
            TradeData("INTC", "Intel", "27,88 EUR"),
            TradeData("JNJ", "Johnson & Johnson ", "160,55 EUR"),
            TradeData("GOOG", "Alphabet inc", "92,73 EUR"),
            TradeData("CSCO", "Cisco Systems", "50,77 EUR"),
            TradeData("DIS", "The Walt Disney co", "140,13 EUR"),
            TradeData("VZ", "Verizon", "40,98 EUR"),
            TradeData("PG", "Procter & Gamble", "140,01 EUR"),
            TradeData("NVDA", "NVIDIA Corporation", "213,88 EUR"),
        )


    val fundamentals = Fundamentals(
        per = "15.5",
        dividendYield = "4.5%",
        earningsPerShare = "5 EUR",
        ratioDebtEbitda = "2.1"
    )

    val value = AssetsScreenData(prices.map { AssetViewData(it, fundamentals) })
}


