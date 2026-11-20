package com.sopt.daisomall.presentation.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import com.sopt.daisomall.presentation.home.navigation.homeNavGraph
import com.sopt.daisomall.presentation.home.navigation.navigateToHome
import com.sopt.daisomall.presentation.search.navigation.navigateToSearch
import com.sopt.daisomall.presentation.search.navigation.searchNavGraph
import com.sopt.daisomall.presentation.splash.navigation.Splash
import com.sopt.daisomall.presentation.splash.navigation.splashNavGraph
import com.sopt.daisomall.presentation.stockcheck.navigation.navigateToStockCheck
import com.sopt.daisomall.presentation.stockcheck.navigation.stockCheckNavGraph

@Composable
fun MainNavHost(
    appState: MainAppState,
    paddingValues: PaddingValues,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = appState.startDestination,
    ) {
        splashNavGraph(
            navigateToHome = {
                navController.navigateToHome(
                    navOptions = navOptions {
                        popUpTo<Splash> { inclusive = true }
                    },
                )
            },
        )

        homeNavGraph(
            paddingValues = paddingValues,
            navigateToSearch = { keyword -> navController.navigateToSearch(keyword = keyword) },
        )

        searchNavGraph(
            paddingValues = paddingValues,
            navigateBack = navController::navigateUp,
            navigateToStockCheck = { productId -> navController.navigateToStockCheck(productId = productId) },
        )

        stockCheckNavGraph(
            paddingValues = paddingValues,
        )
    }
}
