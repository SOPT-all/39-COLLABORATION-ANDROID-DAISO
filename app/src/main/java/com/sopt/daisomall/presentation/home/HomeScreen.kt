package com.sopt.daisomall.presentation.home

import androidx.compose.material3.Text
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
private fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Text(
       text = "효정,서현 안녕"
    )
}


@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    DaisoMallTheme {
        HomeScreen()
    }
}
