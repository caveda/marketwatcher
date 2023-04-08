package com.victorcaveda.marketwatcher.presentation.portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import com.victorcaveda.marketwatcher.presentation.ui.theme.MarketWatcherTheme

@Composable
fun PortfolioScreen(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Gray)
    ) {
        Text(
            text = "This is the Portfolio"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PortfolioScreenPreview() {
    MarketWatcherTheme {
        Surface {
            PortfolioScreen()
        }
    }
}