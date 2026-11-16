package com.sopt.daisomall.core.designsystem.component.textfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun DaisoBasicTextField(
    state: TextFieldState,
    textColor: Color,
    textStyle: TextStyle,
    placeholder: String,
    placeholderColor: Color,
    placeholderStyle: TextStyle,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onKeyboardAction: KeyboardActionHandler? = null,
    lineLimits: TextFieldLineLimits = TextFieldLineLimits.Default,
    inputTransformation: InputTransformation? = null,
    outputTransformation: OutputTransformation? = null,
    interactionSource: MutableInteractionSource? = null,
    cursorColor: Color = textColor,
    suffix: (@Composable () -> Unit)? = null,
) {
    val internalInteractionSource = interactionSource ?: remember { MutableInteractionSource() }
    val isFocused by internalInteractionSource.collectIsFocusedAsState()

    BasicTextField(
        state = state,
        modifier = modifier,
        enabled = isEnabled,
        textStyle = textStyle.copy(color = textColor),
        keyboardOptions = keyboardOptions,
        onKeyboardAction = onKeyboardAction,
        lineLimits = lineLimits,
        inputTransformation = inputTransformation,
        outputTransformation = outputTransformation,
        interactionSource = internalInteractionSource,
        cursorBrush = SolidColor(cursorColor),
        decorator = { innerTextField ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (!isFocused && state.text.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = placeholderColor,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = placeholderStyle,
                        )
                    }
                    innerTextField()
                }
                suffix?.invoke()
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun DaisoBasicTextFieldPreview() {
    val state = rememberTextFieldState(initialText = "")

    DaisoMallTheme {
        DaisoBasicTextField(
            state = state,
            textColor = DaisoTheme.colors.gray10,
            textStyle = DaisoTheme.typography.body.m14,
            placeholder = "매장, 지역 검색",
            placeholderColor = DaisoTheme.colors.gray4,
            placeholderStyle = DaisoTheme.typography.body.m14,
            suffix = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_search_20),
                    contentDescription = null,
                    tint = Color.Unspecified,
                )
            },
        )
    }

}
