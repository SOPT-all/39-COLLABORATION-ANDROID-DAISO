package com.sopt.daisomall.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.presentation.home.component.HomeLogoBar
import com.sopt.daisomall.presentation.home.component.HomeTopBar

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier.Companion
) {
    HomeScreen(
        modifier = modifier
    )
}

@Composable
private fun HomeScreen(
    modifier: Modifier = Modifier.Companion
) {
    Column(
        modifier = modifier,
    ) {
        LazyColumn(

        ) {
            item {
                HomeLogoBar()
            }
            stickyHeader { HomeTopBar(onSearch = {}) }
            item {  }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    DaisoMallTheme {
        HomeScreen()
    }
}