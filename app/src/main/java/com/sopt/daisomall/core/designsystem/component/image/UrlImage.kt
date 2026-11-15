package com.sopt.daisomall.core.designsystem.component.image

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun UrlImage(
    url: String,
    modifier: Modifier = Modifier,
    @DrawableRes placeholderDrawable: Int? = null,
    contentScale: ContentScale = ContentScale.Fit,
    contentDescription: String? = null,
    crossfade: Boolean = true,
    onSuccess: () -> Unit = {},
) {
    val placeholder = placeholderDrawable?.let { painterResource(it) }
        ?: ColorPainter(DaisoTheme.colors.gray1)

    if (LocalInspectionMode.current) {
        Image(
            painter = placeholder,
            contentDescription = contentDescription,
            contentScale = contentScale,
            modifier = modifier,
        )
        return
    }

    AsyncImage(
        model = ImageRequest.Builder(LocalPlatformContext.current)
            .data(url.ifBlank { null })
            .crossfade(crossfade)
            .build(),
        contentDescription = contentDescription,
        contentScale = contentScale,
        placeholder = placeholder,
        error = placeholder,
        fallback = placeholder,
        onSuccess = { onSuccess() },
        modifier = modifier,
    )
}

@Preview
@Composable
private fun UrlImagePreview() {
    UrlImage(
        url = "",
        modifier = Modifier.size(100.dp),
    )
}
