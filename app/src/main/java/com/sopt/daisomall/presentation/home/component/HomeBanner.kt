package com.sopt.daisomall.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import kotlinx.collections.immutable.ImmutableList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.presentation.home.model.HomeBannerUiModel
import com.sopt.daisomall.presentation.home.model.dummyBanners
import kotlinx.collections.immutable.toImmutableList

private const val INFINITE_START_PAGE = Int.MAX_VALUE / 2

@Composable
fun HomeBanner(
    banners: ImmutableList<HomeBannerUiModel>,
    modifier: Modifier = Modifier,
) {
    if (banners.isEmpty()) return

    // 양쪽으로 무한 스크롤되도록 페이지 수를 크게 잡고, 가운데에서 두 번째 배너로 시작
    val pagerState = rememberPagerState(
        initialPage = INFINITE_START_PAGE - INFINITE_START_PAGE % banners.size + 1,
        pageCount = { Int.MAX_VALUE },
    )

    Box(modifier = modifier) {
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 20.dp),
            pageSpacing = 4.dp,
        ) { page ->
            val banner = banners[page % banners.size]

            MainBannerCard(
                image = banner.image,
                titleText = banner.titleText,
                descriptionText = banner.descriptionText,
            )
        }

        BannerPageIndicator(
            currentPage = pagerState.currentPage % banners.size + 1,
            totalPage = banners.size,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 40.dp, bottom = 20.dp),
        )
    }
}

@Composable
private fun BannerPageIndicator(
    currentPage: Int,
    totalPage: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "$currentPage / $totalPage",
        style = DaisoTheme.typography.caption.r10,
        color = DaisoTheme.colors.white,
        textAlign = TextAlign.Center,
        modifier = modifier
            .width(38.dp)
            .background(
                color = Color.Black.copy(alpha = 0.2f),
                shape = RoundedCornerShape(10.dp),
            )
            .padding(vertical = 4.dp),
    )
}

@Preview
@Composable
private fun HomeBannerPreview() {
    DaisoMallTheme {
        HomeBanner(
            banners = dummyBanners.toImmutableList()
        )
    }
}