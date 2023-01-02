package com.victorcaveda.marketwatcher.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.victorcaveda.marketwatcher.presentation.model.PriceScreenData


@Composable
fun AssetPrice(priceInfo: PriceScreenData, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    )
    {
        Text(
            style = MaterialTheme.typography.titleLarge,
            text = priceInfo.ticker,
            modifier = modifier
        )
        Text(
            style = MaterialTheme.typography.titleLarge,
            text = priceInfo.price,
            modifier = modifier
        )
    }
}
