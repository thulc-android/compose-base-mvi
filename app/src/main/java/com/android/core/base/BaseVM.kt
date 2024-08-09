package com.android.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.core.events.NotifyEvents
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * Created by ThulasiRajan.P on 8/8/2024
 */
abstract class BaseVM<STATE : BaseViewState<*>, ACTION> : ViewModel() {

    private val notifyEvents = Channel<NotifyEvents>(
        capacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val notifyEventsChannel = notifyEvents.receiveAsFlow()

    private val _uiState = MutableStateFlow<BaseViewState<*>>(BaseViewState.Empty)
    val uiState: StateFlow<BaseViewState<*>> = _uiState.asStateFlow()

    abstract fun onTriggerEvent(action: ACTION)

    protected fun setState(state: STATE) = viewModelScope.launch {
        _uiState.emit(state)
    }

    fun sendEvent(event: NotifyEvents) {
        viewModelScope.launch {
            notifyEvents.trySend(event)
        }
    }
}
