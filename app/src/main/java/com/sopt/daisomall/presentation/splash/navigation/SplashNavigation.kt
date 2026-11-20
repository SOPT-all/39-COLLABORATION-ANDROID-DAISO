package com.sopt.daisomall.presentation.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sopt.daisomall.core.navigation.Route
import com.sopt.daisomall.presentation.splash.SplashRoute
import kotlinx.serialization.Serializable

@Serializable
data object Splash : Route

fun NavGraphBuilder.splashNavGraph(
    navigateToHome: () -> Unit,
) {
    composable<Splash> {
        SplashRoute(
            navigateToHome = navigateToHome,
        )
    }
}
