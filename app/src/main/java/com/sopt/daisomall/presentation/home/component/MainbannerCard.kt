package com.sopt.daisomall.presentation.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun MainbannerCard(
    @DrawableRes image: Int,
    titleText: String,
    descriptionText: String,
    modifier: Modifier= Modifier,
) {
    Box(
        modifier = modifier.size(334.dp),
    ) {
        Image(
            painterResource(id=image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .padding(20.dp),
        ) {
            Text(
                text = titleText,
                style = DaisoTheme.typography.title.b24,
                color = DaisoTheme.colors.white
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = descriptionText,
                style = DaisoTheme.typography.body.m16,
                color = DaisoTheme.colors.white
            )
        }
    }
}

@Preview
@Composable
private fun MainbannerCardPreview() {
    DaisoMallTheme {
        MainbannerCard(
            image = R.drawable.img_bigbanner1,
            titleText = "10월 4주차\n다이소 신상",
            descriptionText = "이번주 핫한 신상품을 소개합니다"
        )
    }
}
