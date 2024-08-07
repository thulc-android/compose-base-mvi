package com.android.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.android.core.extension.paddingStartEnd
import com.android.core.extension.paddingTopBottom
import com.android.core.previews.ThemedPreviews
import com.android.core.resource.AppDimens
import com.android.core.resource.AppIcons
import com.android.core.resource.StringRes
import com.android.presentation.login.comp.LoginFooter

/**
 * Created by ThulasiRajan.P on 5/8/2024
 */
@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paddingTopBottom(AppDimens.paddingMedium)
            .paddingStartEnd(AppDimens.paddingMedium),
        contentAlignment = Alignment.Center,
        content = {
            Column {
                Image(
                    painter = painterResource(id = AppIcons.launcherForeGround),
                    contentDescription = StringRes.APP_NAME
                )
                LoginFooter()
            }
        }
    )
}

@ThemedPreviews
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}