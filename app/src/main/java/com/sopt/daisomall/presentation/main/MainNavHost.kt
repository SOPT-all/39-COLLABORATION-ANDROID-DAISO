package com.sopt.daisomall.presentation.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.sopt.daisomall.presentation.home.navigation.homeNavGraph
import com.sopt.daisomall.presentation.search.navigation.navigateToSearch
import com.sopt.daisomall.presentation.search.navigation.searchNavGraph
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
