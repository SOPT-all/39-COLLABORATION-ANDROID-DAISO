package com.sopt.daisomall.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun DaisoTopBar(
    title: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = DaisoTheme.colors.white)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_left_24),
            contentDescription = "뒤로 가기",
            modifier = Modifier
                .size(24.dp)
                .clickable(onClick = onBackClick),
            tint = DaisoTheme.colors.black,
        )

        Text(
            text = title,
            color = DaisoTheme.colors.gray10,
            style = DaisoTheme.typography.title.b18,
            modifier = Modifier.weight(1f),
        )
    }
}

@Preview
@Composable
private fun DaisoTopBarPreview() {
    DaisoMallTheme {
        DaisoTopBar(
            title = "매장재고 조회",
            onBackClick = {},
            modifier = Modifier
                .width(375.dp)
                .height(44.dp)
        )
    }
}
