package com.android.core.base

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.android.core.events.CollectEventsFromVM
import com.android.core.events.NotifyEvents
import com.android.core.navigtation.LocalNavigationManager
import com.android.core.providers.dialog.DialogManager
import kotlinx.coroutines.flow.Flow

/**
 * Created by ThulasiRajan.P on 8/8/2024
 */
@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    notifyEventsChannel: Flow<NotifyEvents>,
    content: @Composable () -> Unit,
) {
    val navigator = LocalNavigationManager.current

    Box(
        modifier = modifier.fillMaxSize(),
        content = {
            CollectEventsFromVM(flow = notifyEventsChannel) { event ->
                when (event) {
                    NotifyEvents.Init -> Log.e("BaseScreen", "Received initl̥")
                    is NotifyEvents.Navigate -> navigator.navigate(event.route)
                    is NotifyEvents.ToggleLoading -> {
                        Log.e("BaseScreen", "Event received to show progress ${event.isLoading}")
                        DialogManager.toggleProgress(event.isLoading)
                    }

                    else -> Unit
                }
            }
            content()
        },
    )
}
