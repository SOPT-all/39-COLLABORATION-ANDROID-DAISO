package com.sopt.daisomall.core.designsystem.component.image

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.common.extensions.noRippleClickable
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme

@Composable
fun DaisoProductImage(
    imageUrl: String,
    width: Dp,
    height: Dp,
    onLikeClick: () -> Unit,
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
) {
    Box(
        modifier = modifier.size(width = width, height = height),
    ) {
        UrlImage(
            url = imageUrl,
            modifier = Modifier.fillMaxSize(),
        )

        Icon(
            imageVector = ImageVector.vectorResource(
                if (isLiked) R.drawable.ic_heart_active_20 else R.drawable.ic_heart_default_20,
            ),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(all = 7.dp)
                .noRippleClickable(onClick = onLikeClick),
            tint = Color.Unspecified,
        )
    }
}

@Preview
@Composable
private fun DaisoProductImagePreview() {
    DaisoMallTheme {
        Row(
            modifier = Modifier.padding(all = 20.dp),
        ) {
            DaisoProductImage(
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTb_ZNwn_XtKKbiDZni5QZXKpcGE7xlo_idImuNR982eg&s=10",
                width = 112.dp,
                height = 148.dp,
                onLikeClick = {},
                isLiked = false,
            )

            Spacer(modifier = Modifier.width(10.dp))

            DaisoProductImage(
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTb_ZNwn_XtKKbiDZni5QZXKpcGE7xlo_idImuNR982eg&s=10",
                width = 112.dp,
                height = 148.dp,
                onLikeClick = {},
                isLiked = true,
            )
        }
    }
}
