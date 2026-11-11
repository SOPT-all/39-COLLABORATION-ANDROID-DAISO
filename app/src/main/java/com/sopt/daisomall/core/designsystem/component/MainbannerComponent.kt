package com.sopt.daisomall.core.designsystem.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.defaultDaisoColors
import com.sopt.daisomall.core.designsystem.theme.defaultDaisoTypography

@Composable
fun MainbannerComponent(
    image: Painter,
    text1: String,
    text2: String,
    text3: String,
) {
    Box(
        modifier = Modifier.size(334.dp),
    ) {
        Image(
            painter=image,
            contentDescription=null,
            modifier= Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .padding(20.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text=text1,
                style = defaultDaisoTypography.title.b24,
                color = defaultDaisoColors.white
            )
            Text(
                text=text2,
                style = defaultDaisoTypography.title.b24,
                color = defaultDaisoColors.white
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text=text3,
                style = defaultDaisoTypography.body.m16,
                color = defaultDaisoColors.white
            )
        }

    }
}

@Preview
@Composable
private fun MainbannerComponentPreview() {
    DaisoMallTheme {
        MainbannerComponent(
            image = painterResource(R.drawable.img_bigbanner1),
            text1 = "10월 4주차",
            text2 = "다이소 신상",
            text3 = "이번주 핫한 신상품을 소개합니다"
        )
    }
}