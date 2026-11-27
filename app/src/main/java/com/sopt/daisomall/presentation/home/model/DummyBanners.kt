package com.sopt.daisomall.presentation.home.model

import com.sopt.daisomall.R
import kotlinx.collections.immutable.persistentListOf

val dummyBanners = persistentListOf(
    HomeBannerUiModel(
        image = R.drawable.img_bigbanner2,
        titleText = "10월 4주차\n다이소 신상",
        descriptionText = "이번주 핫한 신상품을 소개합니다",
    ),
    HomeBannerUiModel(
        image = R.drawable.img_bigbanner1,
        titleText = "10월 4주차\n다이소 신상",
        descriptionText = "이번주 핫한 신상품을 소개합니다",
    ),
    HomeBannerUiModel(
        image = R.drawable.img_bigbanner3,
        titleText = "10월 4주차\n다이소 신상",
        descriptionText = "이번주 핫한 신상품을 소개합니다",
    ),
)
