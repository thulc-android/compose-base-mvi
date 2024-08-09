package com.android.domain.usecase

import androidx.annotation.Keep
import com.android.core.base.BaseUseCase
import com.android.data.dto.response.LoginResponse
import com.android.data.remote.common.ApiResult
import com.android.domain.repository.AuthRepo
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by ThulasiRajan.P on 5/8/2024
 */
class AuthUseCase @Inject constructor(
    private val repository: AuthRepo,
) : BaseUseCase<AuthUseCase.RequestData, LoginResponse>() {

    @Keep
    data class RequestData(val someParameter: String)

    override suspend fun execute(requestData: RequestData): ApiResult<LoginResponse> {
        return repository.onLogin()
    }
}