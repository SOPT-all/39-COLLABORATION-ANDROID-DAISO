package com.sopt.daisomall.presentation.home.model

import androidx.annotation.DrawableRes

data class HomeBannerUiModel(
    @DrawableRes val image: Int,
    val titleText: String,
    val descriptionText: String,
)
