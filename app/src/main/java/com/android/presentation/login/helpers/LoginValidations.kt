package com.android.presentation.login.helpers

import android.util.Patterns

/**
 * Created by ThulasiRajan.P on 5/8/2024
 */
internal class LoginValidations {

    companion object {
        const val PASSWORD_MIN = 6
        const val PASSWORD_MAX = 16
    }

    fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun canLogin(email: String, password: String) {
        val isEmailValid = isValidEmail(email)
        val isPasswordValid = password.length in PASSWORD_MIN..PASSWORD_MAX
    }
}
