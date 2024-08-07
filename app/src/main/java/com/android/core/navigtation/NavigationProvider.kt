package com.android.core.navigtation

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavController

/**
 * Created by ThulasiRajan.P on 7/8/2024
 */
class NavigationProvider(
    val navController: NavController,
) {
    fun navigate(route: String) {
        navController.navigate(route)
    }

    fun goBack() {
        navController.popBackStack()
    }
}

val LocalNavigationManager = staticCompositionLocalOf<NavigationProvider> {
    error("No NavigationManager provided")
}