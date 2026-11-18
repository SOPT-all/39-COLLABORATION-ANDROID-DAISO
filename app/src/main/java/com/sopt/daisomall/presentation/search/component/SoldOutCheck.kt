package com.sopt.daisomall.presentation.search.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun SoldOutCheck(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_checkbox_default_18),
            contentDescription = null,
            tint = DaisoTheme.colors.gray3,
        )

        Text(
            text = "품절제외",
            color = DaisoTheme.colors.gray6,
            style = DaisoTheme.typography.body.r14,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SoldOutCheckPreview() {
    DaisoMallTheme {
        SoldOutCheck()
    }
}
