package com.android.presentation.login.navigation

import android.os.Parcelable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.android.presentation.login.LoginContract
import kotlinx.parcelize.Parcelize


/**
 * Created by ThulasiRajan.P on 5/8/2024
 */
internal const val LOGIN = "login"
const val LOGIN_WITH_ARGS = "$LOGIN/{args}"

internal fun NavGraphBuilder.loginScreen() {
    composable(
        route = LOGIN_WITH_ARGS,
        arguments = listOf(navArgument(name = "args") { type = NavType.StringType }),
    ) { navBack ->
        navBack.arguments?.getString("args")?.let { _ ->
            LoginContract {

            }
        }
    }
}

@Parcelize
data class LoginArgs(
    val type: String,
) : Parcelable
