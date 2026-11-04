package com.sopt.daisomall.presentation.stockcheck

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme

@Composable
fun StockCheckRoute(
    modifier: Modifier = Modifier
) {
    StockCheckScreen(
        modifier = modifier
    )
}

@Composable
private fun StockCheckScreen(
    modifier: Modifier = Modifier
) {

}


@Preview(showBackground = true)
@Composable
private fun StockCheckScreenPreview() {
    DaisoMallTheme {
        StockCheckScreen()
    }
}
