package com.sopt.daisomall.presentation.stockcheck.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.daisomall.core.navigation.Route
import com.sopt.daisomall.presentation.stockcheck.StockCheckRoute
import kotlinx.serialization.Serializable

@Serializable
data class StockCheck(val productId: Long) : Route

fun NavController.navigateToStockCheck(
    productId: Long,
    navOptions: NavOptions? = null,
) {
    navigate(StockCheck(productId = productId), navOptions)
}

fun NavGraphBuilder.stockCheckNavGraph(
    paddingValues: PaddingValues,
    navigateBack: () -> Unit,
) {
    composable<StockCheck> {
        StockCheckRoute(
            paddingValues = paddingValues,
            navigateBack = navigateBack,
        )
    }
}
