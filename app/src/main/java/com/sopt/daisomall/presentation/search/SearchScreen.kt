package com.sopt.daisomall.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.component.button.DaisoFilter
import com.sopt.daisomall.core.designsystem.component.chip.DaisoBasicChip
import com.sopt.daisomall.core.designsystem.component.chip.DaisoDropdownChip
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme
import com.sopt.daisomall.presentation.search.component.ProductCard
import com.sopt.daisomall.presentation.search.component.SearchTextFieldTopBar

@Composable
fun SearchRoute(
    modifier: Modifier = Modifier
) {
    SearchScreen(
        modifier = modifier
    )
}

@Composable
private fun SearchScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = DaisoTheme.colors.white),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SearchTextFieldTopBar(
            state = TextFieldState(),
            onBackClick = {},
            onSearch = {},
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
        ) {
            item {
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .padding(start = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    DaisoFilter()

                    VerticalDivider(
                        modifier = Modifier.height(15.dp),
                        thickness = 1.dp,
                        color = DaisoTheme.colors.gray4,
                    )

                    DaisoBasicChip(
                        text = "NEW",
                        textColor = DaisoTheme.colors.gray10,
                        textStyle = DaisoTheme.typography.body.r14,
                        backgroundColor = Color.Transparent,
                        onClick = {},
                        borderColor = DaisoTheme.colors.gray1,
                    )

                    DaisoDropdownChip(
                        text = "브랜드",
                        isFilled = true,
                    )

                    DaisoDropdownChip(
                        text = "카테고리",
                        isFilled = true,
                    )

                    DaisoDropdownChip(
                        text = "별점",
                        isFilled = true,
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                Row(
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = DaisoTheme.colors.gray1,
                        )
                        .padding(horizontal = 20.dp, vertical = 5.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    SoldOutCheck()

                    DaisoDropdownChip(
                        text = "추천순",
                        isFilled = false,
                    )
                }
            }

            item {
                ProductCard(
                    productNumber = "1075034",
                    productName = "[생기충전]VT PDRN 톤온 젤리 시트 마스크 1매입",
                    price = "1,000",
                    imageUrl = "",
                    reviewCount = "9,999+",
                    isLiked = false,
                    onLikeClick = {},
                    onFindClick = {},
                    modifier = Modifier.padding(20.dp),
                )
                ProductCard(
                    productNumber = "1075034",
                    productName = "[생기충전]VT PDRN 톤온 젤리 시트 마스크 1매입",
                    price = "1,000",
                    imageUrl = "",
                    reviewCount = "9,999+",
                    isLiked = false,
                    onLikeClick = {},
                    onFindClick = {},
                    modifier = Modifier.padding(20.dp),
                )
                ProductCard(
                    productNumber = "1075034",
                    productName = "[생기충전]VT PDRN 톤온 젤리 시트 마스크 1매입",
                    price = "1,000",
                    imageUrl = "",
                    reviewCount = "9,999+",
                    isLiked = false,
                    onLikeClick = {},
                    onFindClick = {},
                    modifier = Modifier.padding(20.dp),
                )
                ProductCard(
                    productNumber = "1075034",
                    productName = "[생기충전]VT PDRN 톤온 젤리 시트 마스크 1매입",
                    price = "1,000",
                    imageUrl = "",
                    reviewCount = "9,999+",
                    isLiked = false,
                    onLikeClick = {},
                    onFindClick = {},
                    modifier = Modifier.padding(20.dp),
                )
                ProductCard(
                    productNumber = "1075034",
                    productName = "[생기충전]VT PDRN 톤온 젤리 시트 마스크 1매입",
                    price = "1,000",
                    imageUrl = "",
                    reviewCount = "9,999+",
                    isLiked = false,
                    onLikeClick = {},
                    onFindClick = {},
                    modifier = Modifier.padding(20.dp),
                )
                ProductCard(
                    productNumber = "1075034",
                    productName = "[생기충전]VT PDRN 톤온 젤리 시트 마스크 1매입",
                    price = "1,000",
                    imageUrl = "",
                    reviewCount = "9,999+",
                    isLiked = false,
                    onLikeClick = {},
                    onFindClick = {},
                    modifier = Modifier.padding(20.dp),
                )
                ProductCard(
                    productNumber = "1075034",
                    productName = "[생기충전]VT PDRN 톤온 젤리 시트 마스크 1매입",
                    price = "1,000",
                    imageUrl = "",
                    reviewCount = "9,999+",
                    isLiked = false,
                    onLikeClick = {},
                    onFindClick = {},
                    modifier = Modifier.padding(20.dp),
                )
                ProductCard(
                    productNumber = "1075034",
                    productName = "[생기충전]VT PDRN 톤온 젤리 시트 마스크 1매입",
                    price = "1,000",
                    imageUrl = "",
                    reviewCount = "9,999+",
                    isLiked = false,
                    onLikeClick = {},
                    onFindClick = {},
                    modifier = Modifier.padding(20.dp),
                )
                ProductCard(
                    productNumber = "1075034",
                    productName = "[생기충전]VT PDRN 톤온 젤리 시트 마스크 1매입",
                    price = "1,000",
                    imageUrl = "",
                    reviewCount = "9,999+",
                    isLiked = false,
                    onLikeClick = {},
                    onFindClick = {},
                    modifier = Modifier.padding(20.dp),
                )
                ProductCard(
                    productNumber = "1075034",
                    productName = "[생기충전]VT PDRN 톤온 젤리 시트 마스크 1매입",
                    price = "1,000",
                    imageUrl = "",
                    reviewCount = "9,999+",
                    isLiked = false,
                    onLikeClick = {},
                    onFindClick = {},
                    modifier = Modifier.padding(20.dp),
                )
                ProductCard(
                    productNumber = "1075034",
                    productName = "[생기충전]VT PDRN 톤온 젤리 시트 마스크 1매입",
                    price = "1,000",
                    imageUrl = "",
                    reviewCount = "9,999+",
                    isLiked = false,
                    onLikeClick = {},
                    onFindClick = {},
                    modifier = Modifier.padding(20.dp),
                )
            }
        }
    }

}

@Composable
private fun SoldOutCheck() {
    Row(
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
private fun SearchScreenPreview() {
    DaisoMallTheme {
        SearchScreen()
    }
}
