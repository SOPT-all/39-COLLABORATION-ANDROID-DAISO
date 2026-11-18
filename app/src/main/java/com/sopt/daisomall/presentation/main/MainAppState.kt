package com.sopt.daisomall.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.sopt.daisomall.core.navigation.Route
import com.sopt.daisomall.core.navigation.MainTabRoute
import com.sopt.daisomall.presentation.home.navigation.navigateToHome
import com.sopt.daisomall.presentation.search.navigation.navigateToSearch
import com.sopt.daisomall.presentation.stockcheck.navigation.StockCheck
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Stable
class MainAppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
) {
    val startDestination: Route = MainTabRoute.Home

    private val currentDestination: StateFlow<NavDestination?> = navController.currentBackStackEntryFlow
        .map { it.destination }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null,
        )

    val currentTab: StateFlow<MainTab?> = currentDestination
        .map { destination ->
            when {
                destination == null -> null
                // 매장조회는 재고조회 탭의 하위 화면
                destination.hasRoute(StockCheck::class) -> MainTab.STOCK_CHECK
                else -> MainTab.find { route -> destination.hasRoute(route::class) }
            }
        }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null,
        )

    val isBottomBarVisible: StateFlow<Boolean> = currentTab
        .map { tab -> tab != null }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false,
        )

    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }

        when (tab) {
            MainTab.HOME -> navController.navigateToHome(navOptions = navOptions)
            MainTab.STOCK_CHECK -> navController.navigateToSearch(navOptions = navOptions)
            // 화면 구현 범위 밖이라 탭 이동 없음
            MainTab.CATEGORY, MainTab.DISCOVER, MainTab.MY_PAGE -> Unit
        }
    }
}

@Composable
fun rememberMainAppState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
): MainAppState = remember(navController, coroutineScope) {
    MainAppState(navController, coroutineScope)
}
