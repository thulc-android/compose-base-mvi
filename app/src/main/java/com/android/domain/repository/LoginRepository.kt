package com.android.domain.repository

import com.android.data.dto.response.LoginResponse

/**
 * Created by ThulasiRajan.P on 5/8/2024
 */
interface LoginRepository {
    suspend fun onLogin() : LoginResponse
}