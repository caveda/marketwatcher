package com.victorcaveda.marketwatcher.presentation.home

import android.content.res.Configuration
import android.view.View
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.victorcaveda.marketwatcher.R
import com.victorcaveda.marketwatcher.presentation.model.AssetViewData
import com.victorcaveda.marketwatcher.presentation.model.AssetsScreenData
import com.victorcaveda.marketwatcher.presentation.model.Fundamentals
import com.victorcaveda.marketwatcher.presentation.model.TradeData
import com.victorcaveda.marketwatcher.presentation.ui.theme.MarketWatcherTheme


@Composable
fun AssetPrice(assetData: AssetViewData, modifier: Modifier = Modifier) {
    var isExpanded by remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable {isExpanded = !isExpanded}
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        )
        {
            val surfaceColor by animateColorAsState(
                if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
            )

            AssetTradeDataView(assetData.tradeInfo, modifier)

            AnimatedVisibility(visible = isExpanded) {
                Surface(
                    shape = MaterialTheme.shapes.small,
                    shadowElevation = 1.dp,
                    color = surfaceColor,
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp)
                )
                {
                    AssetFundamentalsView(assetData.fundamentals, modifier)
                }
            }
        }
    }
}

@Composable
fun AssetFundamentalsView(fundamentals: Fundamentals, modifier: Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .size(40.dp)
    ) {
        Text(
            style = MaterialTheme.typography.bodySmall,
            text = "PER: ${fundamentals.per}",
            modifier = Modifier.align(Alignment.TopStart)
        )
        Text(
            style = MaterialTheme.typography.bodySmall,
            text = "Dividend Yield: ${fundamentals.dividendYield}",
            modifier = Modifier.align(Alignment.TopEnd)
        )
        Text(
            style = MaterialTheme.typography.bodySmall,
            text = "Earnings Per Share: ${fundamentals.earningsPerShare}",
            modifier = Modifier.align(Alignment.BottomStart)
        )
        Text(
            style = MaterialTheme.typography.bodySmall,
            text = "Debt/Ebitda: ${fundamentals.ratioDebtEbitda}",
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}

@Composable
fun AssetTradeDataView(tradeData: TradeData, modifier: Modifier) {
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
            AssetNameView(tradeData, modifier)
        }
        Text(
            style = MaterialTheme.typography.titleLarge,
            text = tradeData.price
        )
    }
}

@Composable
fun AssetNameView(priceInfo: TradeData, modifier: Modifier) {
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
            AssetPrice(assetData = item, modifier)
        }
    }
}


@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
private fun PreviewAssets() {
    MarketWatcherTheme {
        Surface {
            Assets(
                SampleAssetPriceData.value
            )
        }
    }
}

