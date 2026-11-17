package com.sopt.daisomall.presentation.stockcheck.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.component.image.UrlImage
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme
import com.sopt.daisomall.R

@Composable
fun CardimgProduct(
    isOpen: Boolean,
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    Box(
      modifier = modifier
    ) {
        UrlImage(
            url = imageUrl,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )

        CustomStatusChip(
            isOpen = isOpen,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun CustomStatusChip(
    isOpen: Boolean,
    modifier: Modifier = Modifier,
) {
    val iconRes = if (isOpen) R.drawable.ic_open_6 else R.drawable.ic_close_6

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = DaisoTheme.colors.gray8)
            .padding(vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(space = 3.dp, alignment = Alignment.CenterHorizontally,),
    ) {
        Icon(
            modifier = Modifier.size(6.dp),
            imageVector = ImageVector.vectorResource(id = iconRes),
            contentDescription = null,
            tint = Color.Unspecified,
        )

        Text(
            text = if (isOpen) "영업중" else "영업종료",
            style = DaisoTheme.typography.caption.b10,
            color = DaisoTheme.colors.white,
            maxLines = 1,
            softWrap = false,
        )
    }
}

@Preview(name = "영업중", showBackground = true, widthDp = 82, heightDp = 110)
@Composable
private fun CardImgProductOpenPreview() {
    DaisoMallTheme {
        CardimgProduct(
            imageUrl = "",
            isOpen = true,
        )
    }
}

@Preview(name = "영업종료", showBackground = true, widthDp = 82, heightDp = 110)
@Composable
private fun CardImgProductClosePreview() {
    DaisoMallTheme {
        CardimgProduct(
            imageUrl = "",
            isOpen = false,
        )
    }
}
