package com.sopt.daisomall.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme
import kotlinx.coroutines.delay

private const val SPLASH_DURATION_MILLIS = 1_500L

@Composable
fun SplashRoute(
    navigateToHome: () -> Unit,
) {
    val currentNavigateToHome by rememberUpdatedState(navigateToHome)

    LaunchedEffect(Unit) {
        delay(SPLASH_DURATION_MILLIS)
        currentNavigateToHome()
    }

    SplashScreen()
}

@Composable
private fun SplashScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = DaisoTheme.colors.white),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_logo),
            contentDescription = null,
            modifier = Modifier.size(150.dp),
        )

        Image(
            painter = painterResource(id = R.drawable.img_logo_typo),
            contentDescription = null,
            modifier = Modifier.size(width = 183.dp, height = 95.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
    DaisoMallTheme {
        SplashScreen()
    }
}
