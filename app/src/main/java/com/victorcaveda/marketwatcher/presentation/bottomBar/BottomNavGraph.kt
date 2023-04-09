package com.victorcaveda.marketwatcher.presentation.bottomBar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.victorcaveda.marketwatcher.presentation.home.HomeScreen
import com.victorcaveda.marketwatcher.presentation.portfolio.PortfolioScreen
import com.victorcaveda.marketwatcher.presentation.settings.SettingsScreen


@Composable
fun BottomNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route, modifier = modifier) {
        composable(BottomBarScreen.Home.route) { HomeScreen() }
        composable(BottomBarScreen.Portfolio.route) { PortfolioScreen() }
        composable(BottomBarScreen.Settings.route) { SettingsScreen() }
        /*...*/
    }
}




