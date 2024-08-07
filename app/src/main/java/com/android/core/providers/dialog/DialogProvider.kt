package com.android.core.providers.dialog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.staticCompositionLocalOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by ThulasiRajan.P on 5/8/2024
 */
typealias DialogContent = @Composable (() -> Unit) -> Unit

val LocalDialogManager = staticCompositionLocalOf<DialogManager> {
    error("No DialogManager provided")
}

class DialogManager(private val coroutineScope: CoroutineScope) {
    var showDialog: (DialogContent) -> Unit = {}
    private var _currentDialogContent = mutableStateOf<DialogContent?>(null)

    val currentDialogContent: DialogContent?
        get() = _currentDialogContent.value

    fun setDialogContent(content: DialogContent?, autoDismissTime: Long = 2L) {
        _currentDialogContent.value = content

        if (autoDismissTime > 0) {
            coroutineScope.launch {
                delay(autoDismissTime)
                _currentDialogContent.value = null
            }
        }
    }

    fun dismissDialog() {
        _currentDialogContent.value = null
    }
}