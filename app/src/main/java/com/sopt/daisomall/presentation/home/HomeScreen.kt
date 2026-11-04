package com.sopt.daisomall.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier
) {
    HomeScreen(
        modifier = modifier
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    DaisoMallTheme {
        HomeScreen()
    }
}
