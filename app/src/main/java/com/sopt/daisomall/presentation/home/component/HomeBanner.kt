package com.sopt.daisomall.presentation.home.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme

data class HomeBannerData(
    val imge: Int,
    val titleText: String,
    val descriptionText: String,
)

@Composable
fun HomeBanner(
    banners: List<HomeBannerData>,
    modifier: Modifier = Modifier,
) {
    val pagerState= rememberPagerState(
        initialPage = 1,
        pageCount = { banners.size },
    )
    HorizontalPager(
        state = pagerState,
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 20.dp),
        pageSpacing = 4.dp,
    ) {
        page -> val banner=banners[page]

        MainBannerCard(
            image = banner.imge,
            titleText = banner.titleText,
            descriptionText = banner.descriptionText,
        )
    }
}

@Preview
@Composable
private fun HomeBannerPreview() {
    DaisoMallTheme {
        HomeBanner(banners = listOf(
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