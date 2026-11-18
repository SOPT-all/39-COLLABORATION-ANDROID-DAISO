package com.sopt.daisomall.presentation.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.daisomall.core.navigation.MainTabRoute
import com.sopt.daisomall.presentation.home.HomeRoute

fun NavController.navigateToHome(
    navOptions: NavOptions? = null,
) {
    navigate(MainTabRoute.Home, navOptions)
}

fun NavGraphBuilder.homeNavGraph(
    paddingValues: PaddingValues,
    navigateToSearch: (String) -> Unit,
) {
    composable<MainTabRoute.Home> {
        HomeRoute(
            paddingValues = paddingValues,
            navigateToSearch = navigateToSearch,
        )
    }
}
