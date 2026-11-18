package com.sopt.daisomall.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme
import com.sopt.daisomall.presentation.home.component.HomeBanner
import com.sopt.daisomall.presentation.home.component.HomeBannerData
import com.sopt.daisomall.presentation.home.component.HomeLogoBar
import com.sopt.daisomall.presentation.home.component.HomeProductRow
import com.sopt.daisomall.presentation.home.component.HomeQuickMenuRow
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

            item {
                HomeQuickMenuRow(modifier = Modifier.padding(vertical = 20.dp),)
            }

            item {
                Image(
                    painter = painterResource(id=R.drawable.img_stripbanner),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(horizontal = 20.dp),
                )
            }
            item{Spacer(modifier = Modifier.height(40.dp))}

            item {
                Text(
                    text = "고객님을 위한 오늘 추천상품",
                    style = DaisoTheme.typography.title.b18,
                    color = DaisoTheme.colors.black,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }

            item{Spacer(modifier = Modifier.height(16.dp))}

            item {
                HomeProductRow(
                    products = TODO(),
                    onLikeClick = TODO(),
                    modifier = TODO()
                )
            }
        }

    }
}





@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    DaisoMallTheme {
        HomeRoute()
    }
}
