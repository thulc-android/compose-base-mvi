package com.android.presentation.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.core.navigtation.LocalNavigationManager
import com.android.presentation.login.LoginContract


/**
 * Created by ThulasiRajan.P on 5/8/2024
 */
const val LOGIN = "login"

internal fun NavGraphBuilder.loginScreen() {
    composable(LOGIN) {
        LoginContract {

        }
    }
}
