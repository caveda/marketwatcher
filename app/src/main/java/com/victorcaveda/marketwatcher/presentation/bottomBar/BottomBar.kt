package com.victorcaveda.marketwatcher.presentation.bottomBar

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.victorcaveda.marketwatcher.R

sealed class BottomBarScreen(
    val route: String,
    @StringRes val title: Int,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "home",
        title = R.string.home_screen_title,
        icon = Icons.Default.Home
    )

    object Portfolio : BottomBarScreen(
        route = "portfolio",
        title = R.string.portfolio_screen_title,
        icon = Icons.Default.List
    )

    object Settings : BottomBarScreen(
        route = "settings",
        title = R.string.settings_screen_title,
        icon = Icons.Default.Settings
    )
}

// All items included in the bottomBar
val bottomBarItems = listOf(
    BottomBarScreen.Home,
    BottomBarScreen.Portfolio,
    BottomBarScreen.Settings
)