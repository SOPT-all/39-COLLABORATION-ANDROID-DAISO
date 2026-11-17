package com.sopt.daisomall.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.presentation.home.component.HomeBanner
import com.sopt.daisomall.presentation.home.component.HomeBannerData
import com.sopt.daisomall.presentation.home.component.HomeLogoBar
import com.sopt.daisomall.presentation.home.component.HomeTopBar

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier.Companion
) {
    HomeScreen(
        onSearch = {},
        modifier = modifier
    )
}

@Composable
private fun HomeScreen(
    onSearch : () -> Unit,
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
            item {
                HomeBanner(
                    banners = listOf(
                        HomeBannerData(
                            imge = R.drawable.img_bigbanner2,
                            titleText = "10월 4주차 다이소 신상",
                            descriptionText = "이번주 핫한 신상품을 소개합니다",
                        ),
                        HomeBannerData(
                            imge = R.drawable.img_bigbanner1,
                            titleText = "10월 4주차 다이소 신상",
                            descriptionText = "이번주 핫한 신상품을 소개합니다",
                        ),
                        HomeBannerData(
                            imge = R.drawable.img_bigbanner3,
                            titleText = "10월 4주차 다이소 신상",
                            descriptionText = "이번주 핫한 신상품을 소개합니다",
                        ),
                    )
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    DaisoMallTheme {
        HomeScreen(onSearch = {})
    }
}