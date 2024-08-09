package com.android.presentation.splash

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.android.core.extension.paddingStartEnd
import com.android.core.extension.paddingTopBottom
import com.android.core.previews.ThemedPreviews
import com.android.core.providers.dialog.DialogManager
import com.android.core.resource.AppDimens

/**
 * Created by ThulasiRajan.P on 5/8/2024
 */
@Composable
fun SplashScreen(
    onAction: (SplashAction) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paddingTopBottom(AppDimens.paddingMedium)
            .paddingStartEnd(AppDimens.paddingMedium),
        contentAlignment = Alignment.Center,
        content = {
            Column {
                Text(
                    text = "Single Action Dialog",
                    modifier = Modifier
                        .paddingTopBottom(AppDimens.paddingLarge)
                        .clickable {
                            DialogManager.showSingleActionDialog(
                                message = "This is a single action dialog",
                                onConfirm = {
                                    DialogManager.dismissDialog()
                                }
                            )
                        },
                )
                Text(
                    text = "Multi Action Dialog",
                    modifier = Modifier
                        .paddingTopBottom(AppDimens.paddingLarge)
                        .clickable {
                            DialogManager.showMultiActionDialog(
                                message = "Click yes if you want to move to next screen!",
                                onConfirm = {
                                    DialogManager.dismissDialog()
                                    onAction.invoke(SplashAction.ShowProgressAndMove)
                                },
                                onDismiss = {
                                    DialogManager.dismissDialog()
                                }
                            )
                        },
                )
            }
        }
    )
}

@ThemedPreviews
@Composable
fun SplashScreenPreview() {
    SplashScreen(onAction = {})
}