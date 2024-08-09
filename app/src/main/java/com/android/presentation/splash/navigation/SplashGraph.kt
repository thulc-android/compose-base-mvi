package com.android.presentation.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.presentation.splash.SplashContract

/**
 * Created by ThulasiRajan.P on 5/8/2024
 */
const val SPLASH = "splash"

internal fun NavGraphBuilder.splashScreen() {
    composable(SPLASH) {
        SplashContract()
    }
}
