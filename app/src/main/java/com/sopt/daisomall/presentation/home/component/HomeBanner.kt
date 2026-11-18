package com.sopt.daisomall.presentation.home.component

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


@Composable
fun HomeBanner(
    banners: ImmutableList<HomeBannerUiModel>,
    modifier: Modifier = Modifier,
) {
    val pagerState= rememberPagerState(
        initialPage = 1,
        pageCount = { banners.size / 2 },
    )

    HorizontalPager(
        state = pagerState,
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 20.dp),
        pageSpacing = 4.dp,
    ) { page ->
        val banner=banners[page]

        MainBannerCard(
            image = banner.image,
            titleText = banner.titleText,
            descriptionText = banner.descriptionText,
        )
    }
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