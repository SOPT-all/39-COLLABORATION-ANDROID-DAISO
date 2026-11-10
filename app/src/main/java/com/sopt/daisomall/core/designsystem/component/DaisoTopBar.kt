package com.sopt.daisomall.core.designsystem.component

import android.graphics.drawable.VectorDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.res.painterResource
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
            .padding(horizontal = 20.dp, vertical = 10.dp)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        IconButton(
            onClick = { onBackClick }
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_left_24),
                contentDescription = "뒤로가기 버튼"
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = title,
            color = DaisoTheme.colors.gray9,
            style = DaisoTheme.typography.title.b18,
            modifier = Modifier.weight(1f)

        )
    }
}

@Preview
@Composable
private fun DaisoTopBarPreview() {
    DaisoMallTheme {
        DaisoTopBar(
            title = "매장재고 조회",
            onBackClick = {}
        )
    }
}
