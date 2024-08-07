package com.android.core.events

/**
 * Created by ThulasiRajan.P on 7/8/2024
 */
sealed class UiEvent {
    data class ShowToast(val message: String) : UiEvent()
    data class ShowDialog(val message: String, val onConfirm: () -> Unit) : UiEvent()
    data class ShowProgress(val show: Boolean) : UiEvent()
    data class NavigateTo(val route: String) : UiEvent()
}
