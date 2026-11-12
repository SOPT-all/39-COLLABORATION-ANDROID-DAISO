package com.sopt.daisomall.core.designsystem.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.common.extensions.noRippleClickable
import com.sopt.daisomall.core.designsystem.component.toggle.DaisoToggle
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun DaisoToggleTextField(
    state: TextFieldState,
    placeholder: String,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
    onSearch: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .background(color = DaisoTheme.colors.gray1, shape = RoundedCornerShape(2.dp))
            .padding(horizontal = 10.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        DaisoToggle()

        VerticalDivider(
            modifier = Modifier.height(16.dp),
            thickness = 1.dp,
            color = DaisoTheme.colors.gray2,
        )

        DaisoBasicTextField(
            state = state,
            textColor = DaisoTheme.colors.gray10,
            textStyle = DaisoTheme.typography.body.m14,
            placeholder = placeholder,
            placeholderColor = DaisoTheme.colors.gray4,
            placeholderStyle = DaisoTheme.typography.body.m14,
            modifier = Modifier.weight(1f),
            keyboardOptions = keyboardOptions,
            onKeyboardAction = { onSearch() },
            lineLimits = TextFieldLineLimits.SingleLine,
            suffix = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_search_20),
                    contentDescription = null,
                    modifier = Modifier.noRippleClickable(onClick = onSearch),
                    tint = DaisoTheme.colors.gray6,
                )
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DaisoToggleTextFieldPreview() {
    DaisoMallTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            DaisoToggleTextField(
                state = rememberTextFieldState(),
                placeholder = "상품, 품번, 브랜드 검색",
                modifier = Modifier.fillMaxWidth(),
            )
            DaisoToggleTextField(
                state = rememberTextFieldState(initialText = "매장, 지역 검색"),
                placeholder = "상품, 품번, 브랜드 검색",
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}
