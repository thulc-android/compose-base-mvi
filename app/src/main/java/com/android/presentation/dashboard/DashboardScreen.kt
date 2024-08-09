package com.android.presentation.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

/**
 * Created by ThulasiRajan.P on 5/8/2024
 */
@Composable
fun DashboardScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        content = {
            Text(text = "Dashboard", style = TextStyle(fontSize = 28.sp))
        },
    )
}