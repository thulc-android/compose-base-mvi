package com.android.data.repository.login

import com.android.data.dto.response.LoginResponse
import com.android.domain.repository.LoginRepository

/**
 * Created by ThulasiRajan.P on 5/8/2024
 */
class LoginRepoImpl() : LoginRepository {
    override suspend fun onLogin(): LoginResponse {
        return LoginResponse(userId = "", userName = "")
    }
}