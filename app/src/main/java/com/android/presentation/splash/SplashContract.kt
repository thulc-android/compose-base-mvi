package com.android.presentation.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.delay

/**
 * Created by ThulasiRajan.P on 5/8/2024
 */
@Composable
fun SplashContract(
    onOpenLogin: () -> Unit,
    onOpenDashboard: () -> Unit,
) {
    val viewModel: SplashViewModel = hiltViewModel<SplashViewModel>()

    //by this we can also pass data to the VM savedState
    // and can access in the VM
    viewModel.savedStateHandle["LaunchDone"] = true

    LaunchedEffect(Unit) {
        delay(1500)
        onOpenDashboard.invoke()
    }

    SplashScreen()
}