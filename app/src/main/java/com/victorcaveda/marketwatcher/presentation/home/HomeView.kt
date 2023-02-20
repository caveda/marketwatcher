package com.victorcaveda.marketwatcher.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.victorcaveda.marketwatcher.presentation.model.HomeState
import com.victorcaveda.marketwatcher.presentation.ui.theme.MarketWatcherTheme


@Composable
fun Home(state: HomeState, refreshAction: () -> Unit, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.padding(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = refreshAction,
                shape = RoundedCornerShape(8.dp),
            ) {
                Text(
                    style = MaterialTheme.typography.bodyLarge,
                    text = "Refresh",
                    modifier = modifier
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Assets(assetsData = state.data, modifier = modifier)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MarketWatcherTheme {
        Home(HomeState(makeFakeAssetPriceData()), {})
    }
}