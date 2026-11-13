
package com.sopt.daisomall.presentation.stockcheck.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
fun TabGroup(
    selectedTab: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(DaisoTheme.colors.white),
    ) {
        // 매장 검색 탭
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = "매장 검색",
                    color = if (selectedTab == 0) {
                        DaisoTheme.colors.gray10
                    } else {
                        DaisoTheme.colors.gray6
                    },
                    style = if (selectedTab == 0) {
                        DaisoTheme.typography.body.b14
                    } else {
                        DaisoTheme.typography.body.m14
                    },
                )

                Icon(
                    imageVector = ImageVector.vectorResource(
                        id = R.drawable.ic_pressed_number_48,
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.Unspecified,
                )
            }

            if (selectedTab == 0) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(DaisoTheme.colors.gray10),
                )
            }
        }

        // 관심 매장 탭
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "관심 매장",
                color = if (selectedTab == 1) {
                    DaisoTheme.colors.gray10
                } else {
                    DaisoTheme.colors.gray6
                },
                style = if (selectedTab == 1) {
                    DaisoTheme.typography.body.b14
                } else {
                    DaisoTheme.typography.body.m14
                },
            )

            if (selectedTab == 1) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(DaisoTheme.colors.gray10),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TabGroupPreview() {
    DaisoMallTheme {
        TabGroup(
            selectedTab = 0,
        )
    }
}