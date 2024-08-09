package com.android.core.base

import com.android.data.remote.common.ApiResult


/**
 * Created by ThulasiRajan.P on 9/8/2024
 */
abstract class BaseUseCase<in Params, Result>() {
    suspend operator fun invoke(params: Params): ApiResult<Result> {
        return execute(params)
    }

    protected abstract suspend fun execute(requestData: Params): ApiResult<Result>
}
