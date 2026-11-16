package com.sopt.daisomall.presentation.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.daisomall.core.navigation.Route
import com.sopt.daisomall.presentation.search.SearchRoute
import kotlinx.serialization.Serializable

@Serializable
data class Search(val keyword: String = "") : Route

fun NavController.navigateToSearch(
    keyword: String = "",
    navOptions: NavOptions? = null,
) {
    navigate(Search(keyword = keyword), navOptions)
}

fun NavGraphBuilder.searchNavGraph(
    navigateBack: () -> Unit,
    navigateToStockCheck: (Long) -> Unit,
) {
    composable<Search> {
        SearchRoute(
            navigateBack = navigateBack,
            navigateToStockCheck = navigateToStockCheck,
        )
    }
}