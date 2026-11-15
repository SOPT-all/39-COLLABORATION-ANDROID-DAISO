package com.sopt.daisomall.presentation.stockcheck.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun SmallSearchBar(
    modifier: Modifier = Modifier,
) {
    val shape = RoundedCornerShape(2.dp)

    Row(
        modifier = modifier
            .border(width = 1.dp, color = DaisoTheme.colors.gray3, shape = shape)
            .background(color = DaisoTheme.colors.white, shape = shape)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "매장, 지역 검색",
            modifier = Modifier.weight(1f),
            color = DaisoTheme.colors.gray4,
            style = DaisoTheme.typography.body.m14,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_search_20),
            contentDescription = null,
            tint = DaisoTheme.colors.gray6,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SmallSearchBarPreview() {
    DaisoMallTheme {
        SmallSearchBar(
            modifier = Modifier.width(227.dp),
        )
    }
}
