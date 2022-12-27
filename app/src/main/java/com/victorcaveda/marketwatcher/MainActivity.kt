package com.victorcaveda.marketwatcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.victorcaveda.marketwatcher.presentation.home.Home
import com.victorcaveda.marketwatcher.presentation.home.HomeViewModel
import com.victorcaveda.marketwatcher.presentation.ui.theme.MarketWatcherTheme

class MainActivity : ComponentActivity() {

    private val viewModel: HomeViewModel = HomeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadData()

        setContent {
            MarketWatcherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home(viewModel.state)
                }
            }
        }
    }
}

