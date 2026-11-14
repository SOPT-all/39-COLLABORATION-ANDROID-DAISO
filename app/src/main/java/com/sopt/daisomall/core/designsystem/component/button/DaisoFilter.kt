package com.sopt.daisomall.core.designsystem.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun DaisoFilter(
    modifier: Modifier = Modifier,
) {
    Icon(
        imageVector = ImageVector.vectorResource(R.drawable.ic_filter_20),
        contentDescription = null,
        modifier = modifier
            .background(color = DaisoTheme.colors.white, shape = CircleShape)
            .border(1.dp, color = DaisoTheme.colors.gray2, shape = CircleShape)
            .padding(7.dp),
        tint = DaisoTheme.colors.gray9,
    )
}

@Preview
@Composable
private fun DaisoFilterPreview() {
    DaisoMallTheme {
        DaisoFilter()
    }
}
