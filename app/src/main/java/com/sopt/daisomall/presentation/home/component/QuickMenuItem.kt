package com.sopt.daisomall.presentation.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
fun QuickMenuItem(
    @DrawableRes image: Int,
    text: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.Crop,
        )

        Text(
            text = text,
            color = DaisoTheme.colors.black,
            style = DaisoTheme.typography.body.m11,
            maxLines = 1,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun QuickMenuItemPreview() {
    DaisoMallTheme {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            QuickMenuItem(image = R.drawable.img_quickbanner1, text = "다이소핫템")
            QuickMenuItem(image = R.drawable.img_quickbanner2, text = "랭킹")
            QuickMenuItem(image = R.drawable.img_quickbanner3, text = "기획전")
            QuickMenuItem(image = R.drawable.img_quickbanner4, text = "신상")
            QuickMenuItem(image = R.drawable.img_quickbanner5, text = "오늘배송")
        }
    }
}
