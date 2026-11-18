package com.sopt.daisomall.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.daisomall.R
import androidx.compose.runtime.getValue
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme
import com.sopt.daisomall.presentation.home.component.HomeBanner
import com.sopt.daisomall.presentation.home.component.HomeLogoBar
import com.sopt.daisomall.presentation.home.component.HomeProductRow
import com.sopt.daisomall.presentation.home.component.HomeQuickMenuRow
import com.sopt.daisomall.presentation.home.component.HomeTopBar
import com.sopt.daisomall.presentation.home.model.dummyBanners
import com.sopt.daisomall.presentation.home.model.dummyHomeProduct

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    viewModel: HomeViewModel = viewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    HomeScreen(
        state = state,
        onLikeClick = viewModel::onLikeClick,
        onSearch = viewModel::onSearch,
        modifier = Modifier.padding(PaddingValues()),
    )
}

@Composable
private fun HomeScreen(
    state: HomeUiState,
    onLikeClick: (Long) -> Unit,
    onSearch : () -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier=modifier
            .fillMaxSize()
            .padding(bottom = 21.dp
            )
            .background(color = DaisoTheme.colors.white)
    ) {
        item {
            HomeLogoBar()
        }

        stickyHeader { HomeTopBar(onSearch = onSearch) }

        item {
            HomeBanner(
                banners = dummyBanners,
            )
        }

        item {
            HomeQuickMenuRow(modifier = Modifier.padding(vertical = 20.dp),)
        }

        item {
            Image(
                painter = painterResource(id=R.drawable.img_stripbanner),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(horizontal = 20.dp),
            )
        }

        item{Spacer(modifier = Modifier.height(40.dp))}

        item {
            Text(
                text = "고객님을 위한 오늘 추천상품",
                style = DaisoTheme.typography.title.b18,
                color = DaisoTheme.colors.black,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }

        item{Spacer(modifier = Modifier.height(16.dp))}

        item {
            HomeProductRow(
                products = state.productList,
                onLikeClick = onLikeClick,
                paddingValues = PaddingValues(horizontal = 20.dp),
                modifier = Modifier,
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    DaisoMallTheme {
        HomeScreen(
            state = HomeUiState(
                productList = dummyHomeProduct,
            ),
            onLikeClick = {} ,
            onSearch = {},
        )
    }
}
