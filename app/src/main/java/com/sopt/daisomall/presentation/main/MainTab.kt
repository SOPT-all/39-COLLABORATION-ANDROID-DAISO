package com.sopt.daisomall.presentation.main

import androidx.annotation.DrawableRes
import com.sopt.daisomall.R
import com.sopt.daisomall.core.navigation.MainTabRoute
import com.sopt.daisomall.core.navigation.Route

enum class MainTab(
    @param:DrawableRes val iconRes: Int,
    @param:DrawableRes val selectedIconRes: Int,
    val route: MainTabRoute,
    val label: String,
) {
    HOME(
        iconRes = R.drawable.ic_home_default_24,
        selectedIconRes = R.drawable.ic_home_pressed_24,
        route = MainTabRoute.Home,
        label = "홈",
    ),
    CATEGORY(
        iconRes = R.drawable.ic_category_24,
        selectedIconRes = R.drawable.ic_category_24,
        route = MainTabRoute.Category,
        label = "카테고리",
    ),
    STOCK_CHECK(
        iconRes = R.drawable.ic_stock_24,
        selectedIconRes = R.drawable.ic_stock_24,
        route = MainTabRoute.StockCheck,
        label = "재고조회",
    ),
    DISCOVER(
        iconRes = R.drawable.ic_play_24,
        selectedIconRes = R.drawable.ic_play_24,
        route = MainTabRoute.Discover,
        label = "발견",
    ),
    MY_PAGE(
        iconRes = R.drawable.ic_mypage_24,
        selectedIconRes = R.drawable.ic_mypage_24,
        route = MainTabRoute.MyPage,
        label = "마이",
    ),
    ;

    companion object {
        fun find(predicate: (MainTabRoute) -> Boolean): MainTab? =
            entries.find { predicate(it.route) }

        fun contains(predicate: (Route) -> Boolean): Boolean =
            entries.map { it.route }.any { predicate(it) }
    }
}
