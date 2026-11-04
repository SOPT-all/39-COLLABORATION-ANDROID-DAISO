package com.sopt.daisomall.presentation.search

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier
) {
    SearchScreen(
        modifier = modifier
    )
}

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier
) {

}


@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    DaisoMallTheme {
        SearchScreen()
    }
}
