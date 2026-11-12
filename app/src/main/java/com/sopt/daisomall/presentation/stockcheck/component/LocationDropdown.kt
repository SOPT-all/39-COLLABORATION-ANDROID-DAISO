package com.sopt.daisomall.presentation.stockcheck.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun LocationDropdown(
    modifier: Modifier = Modifier,
) {
    val shape = RoundedCornerShape(size = 2.dp)

    Row(
        modifier = modifier
            .border(1.dp, color = DaisoTheme.colors.gray3, shape = shape)
            .background(color = DaisoTheme.colors.white, shape = shape)
            .padding(horizontal = 11.dp, vertical = 7.dp)
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(3.dp),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_location_24),
            contentDescription = null,
            tint = Color.Unspecified,
        )

        Text(
            text = "5km",
            style = DaisoTheme.typography.body.m14,
            color = DaisoTheme.colors.gray7,
        )

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_down_24),
            contentDescription = null,
            tint = Color.Unspecified,
        )
    }
}

@Preview
@Composable
private fun LocationDropdownPreview() {
    DaisoMallTheme {
        LocationDropdown()
    }
}
