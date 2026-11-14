package com.sopt.daisomall.presentation.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.component.ButtonType
import com.sopt.daisomall.core.designsystem.component.DaisoButton
import com.sopt.daisomall.core.designsystem.component.image.DaisoProductImage


@Composable
fun HomeRecommendCard(
    productNumber: String,
    productName: String,
    productPrice: String,
    imageUrl: String,
    reviewCount: String,
    isLiked: Boolean,
    isNew: Boolean,
    onLikeClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier=modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        DaisoProductImage(
            imageUrl = imageUrl,
            width = 109.dp,
            height = 144.dp,
            onLikeClick = onLikeClick,
            isLiked = isLiked,
        )

        DaisoButton(
            type= ButtonType.GRAY_LINE,
            icon = painterResource(R.drawable.ic_availablestores_20),
            text = "담기"
        ) { }
    }
}