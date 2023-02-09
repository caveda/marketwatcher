package com.victorcaveda.marketwatcher.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.victorcaveda.marketwatcher.presentation.model.AssetPriceData
import com.victorcaveda.marketwatcher.presentation.model.AssetsScreenData


@Composable
fun AssetPrice(priceInfo: AssetPriceData, modifier: Modifier = Modifier) {
    val customCardColors = CardDefaults.cardColors(
        contentColor = MaterialTheme.colorScheme.primary,
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        disabledContentColor = MaterialTheme.colorScheme.surface,
        disabledContainerColor = MaterialTheme.colorScheme.onSurface,
    )
    val customCardElevation = CardDefaults.cardElevation(
        defaultElevation = 8.dp,
        pressedElevation = 2.dp,
        focusedElevation = 4.dp
    )

    Card(
        colors = customCardColors,
        modifier = modifier.padding(8.dp),
        elevation = customCardElevation,
    ){
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
}

@Composable
fun Assets(assetsData: AssetsScreenData, modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(assetsData.assets) { item ->
            AssetPrice(priceInfo = item, modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AssetsPreview() {
    Assets(
        AssetsScreenData(
            MutableList(10)
            { AssetPriceData("ABC", "100,123 EUR") }
        ))
}