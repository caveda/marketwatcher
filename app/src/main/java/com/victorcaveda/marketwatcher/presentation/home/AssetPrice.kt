package com.victorcaveda.marketwatcher.presentation.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.victorcaveda.marketwatcher.presentation.model.HomeState
import com.victorcaveda.marketwatcher.presentation.model.PriceScreenData
import com.victorcaveda.marketwatcher.presentation.ui.theme.MarketWatcherTheme


@Composable
fun Home(state: HomeState, modifier: Modifier = Modifier) {
    AssetPrice(priceInfo = state.assetPrice, modifier)
}

@Composable
fun AssetPrice(priceInfo: PriceScreenData, modifier: Modifier = Modifier) {
    Text(
        text = priceInfo.price,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MarketWatcherTheme {
        AssetPrice(PriceScreenData("100,123 EUR"))
    }
}