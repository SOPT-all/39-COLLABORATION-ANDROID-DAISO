package com.sopt.daisomall.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.component.image.UrlImage
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme
import com.sopt.daisomall.R

@Composable
fun cardimgProduct(
    isOpen: Boolean,
    imageUrl: String,
    modifier: Modifier = Modifier,
    ) {
    Box(
        modifier = modifier.size(
            width = 82.dp,
            height = 110.dp,
        ),
    ) {
        UrlImage(
            url = imageUrl,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .width(82.dp)
                .height(16.dp)
                .background(color = DaisoTheme.colors.gray8),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(space = 3.dp, alignment = Alignment.CenterHorizontally,            ),
        ) {
            customStatusIcon(
                isOpen = isOpen,
                modifier = Modifier.size(6.dp),
            )

            Text(
                text = if (isOpen) "영업중" else "영업종료",
                style = DaisoTheme.typography.caption.b10,
                color = DaisoTheme.colors.white,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun customStatusIcon(
    isOpen: Boolean,
    modifier: Modifier = Modifier,
) {
    val iconRes = if (isOpen) {
        R.drawable.ic_open_6
    } else {
        R.drawable.ic_close_6
    }

    Icon(
        imageVector = ImageVector.vectorResource(id = iconRes),
        contentDescription = if (isOpen) "영업중" else "영업종료",
        tint = Color.Unspecified,
    )
}

@Preview(name = "영업중")
@Composable
private fun cardImgProductOpenPreview() {
    DaisoMallTheme {
        cardimgProduct(
            imageUrl = "",
            isOpen = true,
        )
    }
}

@Preview(name = "영업종료")
@Composable
private fun cardImgProductClosePreview() {
    DaisoMallTheme {
        cardimgProduct(
            imageUrl = "",
            isOpen = false,
        )
    }
}