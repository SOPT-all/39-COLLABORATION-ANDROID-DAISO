package com.sopt.daisomall.core.navigation

import kotlinx.serialization.Serializable

sealed interface MainTabRoute : Route {
    @Serializable
    data object Home : MainTabRoute

    @Serializable
    data object Category : MainTabRoute

    @Serializable
    data object StockCheck : MainTabRoute

    @Serializable
    data object Discover : MainTabRoute

    @Serializable
    data object MyPage : MainTabRoute
}
