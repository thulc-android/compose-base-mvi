package com.android.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.core.dispatcher.DefaultDispatcher
import com.android.core.dispatcher.IoDispatcher
import com.android.core.dispatcher.MainDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by ThulasiRajan.P on 5/8/2024
 */
@HiltViewModel
class LoginViewModel @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher,
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher,
) : ViewModel() {

    fun onLogin() {
        viewModelScope.launch(ioDispatcher) {} //for background and network operations

        viewModelScope.launch(mainDispatcher) {} //for UI updates

        viewModelScope.launch(defaultDispatcher) {} //this runs for all statements by default
    }
}