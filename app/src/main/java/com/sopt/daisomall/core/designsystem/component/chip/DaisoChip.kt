package com.sopt.daisomall.core.designsystem.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.common.extensions.noRippleClickable
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme

@Composable
fun DaisoChip(
    chipText: String,
    modifier: Modifier = Modifier,
    onChipClick: () -> Unit,
    @DrawableRes frontIcon: Int? =  null,
    @DrawableRes backIcon: Int? =  null,
){
    Row(
        modifier = modifier
            .padding(horizontal = 10.dp, vertical = 6.dp)
            .noRippleClickable(onClick = onChipClick),
    ) {
        if (frontIcon != null){
            Icon(
                imageVector = ImageVector.vectorResource(frontIcon),
                contentDescription = null,
            )
        }

        Text(
            text = chipText,
        )

        if (backIcon != null){
            Icon(
                imageVector = ImageVector.vectorResource(backIcon),
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
private fun DaisoChipPreview(){
    DaisoMallTheme {
        DaisoChip(
            chipText = "",
            onChipClick = {},
        )
    }
}
