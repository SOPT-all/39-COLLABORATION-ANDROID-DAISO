package com.sopt.daisomall.presentation.search.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.common.extensions.noRippleClickable
import com.sopt.daisomall.core.designsystem.component.textfield.DaisoToggleTextField
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme

@Composable
fun TextFieldTopBar(
    state: TextFieldState,
    onBackClick: () -> Unit,
    onSearch: () -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "상품, 품번, 브랜드 검색",
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_left_24),
            contentDescription = null,
            modifier = Modifier
                .noRippleClickable(onClick = onBackClick)
                .padding(10.dp),
            tint = Color.Unspecified,
        )

        DaisoToggleTextField(
            state = state,
            placeholder = placeholder,
            modifier = Modifier.weight(1f),
            onSearch = onSearch,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TextFieldTopBarPreview() {
    DaisoMallTheme {
        TextFieldTopBar(
            state = rememberTextFieldState(initialText = "마스크팩"),
            onBackClick = {},
            onSearch = {},
        )
    }
}
