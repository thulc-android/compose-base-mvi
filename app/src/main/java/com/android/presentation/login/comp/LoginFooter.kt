package com.android.presentation.login.comp

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.android.core.resource.AppIcons

/**
 * Created by ThulasiRajan.P on 5/8/2024
 */
@Composable
fun LoginFooter() {
    Image(
        painter = painterResource(id = AppIcons.launcherBackGround),
        contentDescription = "launcherBackGround",
    )
}
