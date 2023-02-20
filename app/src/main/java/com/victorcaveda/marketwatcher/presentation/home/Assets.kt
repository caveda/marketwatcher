package com.victorcaveda.marketwatcher.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.victorcaveda.marketwatcher.R
import com.victorcaveda.marketwatcher.presentation.model.AssetPriceData
import com.victorcaveda.marketwatcher.presentation.model.AssetsScreenData


@Composable
fun AssetPrice(priceInfo: AssetPriceData, modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,

            )
        {
            Row(
                modifier = Modifier.padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.asset_placeholder),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, Color.White, CircleShape)
                )
                Spacer(modifier = Modifier.size(8.dp))
                AssetName(priceInfo, modifier)
            }
            Text(
                style = MaterialTheme.typography.titleMedium,
                text = priceInfo.price
            )
        }
    }
}

@Composable
private fun AssetName(priceInfo: AssetPriceData, modifier: Modifier) {
    Column {
        Text(
            style = MaterialTheme.typography.titleMedium,
            text = priceInfo.name,
            modifier = modifier
        )
        Text(
            style = MaterialTheme.typography.bodySmall,
            text = priceInfo.ticker,
            modifier = modifier
        )
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
private fun PreviewAssets() {
    Assets(
        makeFakeAssetPriceData()
    )
}

@Composable
internal fun makeFakeAssetPriceData() = AssetsScreenData(
    MutableList(10)
    { AssetPriceData("AMZN", "Amazon", "100,123 EUR") }
)