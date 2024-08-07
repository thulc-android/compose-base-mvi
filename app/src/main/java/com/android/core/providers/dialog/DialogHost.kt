package com.android.core.providers.dialog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState

/**
 * Created by ThulasiRajan.P on 5/8/2024
 */
@Composable
fun DialogHost(
    dialogManager: DialogManager,
    content: @Composable () -> Unit
) {
    val dialogContent by rememberUpdatedState(dialogManager.currentDialogContent)

    dialogContent?.let { _ ->
        AlertDialog(
            onDismissRequest = { dialogManager.dismissDialog() },
            title = { Text(text = "Alert") },
            text = { content() },
            confirmButton = {
                Button(onClick = { dialogManager.dismissDialog() }) {
                    Text("OK")
                }
            }
        )
    }
}