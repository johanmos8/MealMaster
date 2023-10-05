package com.mirkwood.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mirkwood.domain.model.Category

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel

) {
    Scaffold(
        topBar = {
            Text(
                text = "Categories",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    ) {
        val categories by homeViewModel.categories.observeAsState()
        categories?.let { categories ->
            CategoriesGrid(
                modifier = Modifier
                    .padding(paddingValues = it)
                    .background(Color.Gray),
                categories
            )
        }
    }
}

@Composable
fun CategoriesGrid(
    modifier: Modifier,
    categories: List<Category>
) {
    LazyVerticalGrid(
        modifier = modifier.padding(8.dp),
        columns = GridCells.Adaptive(180.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        itemsIndexed(categories) { index, item ->
            CategoryItem(item)

        }
    }

}

@Composable
fun CategoryItem(item: Category) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp)),
    ) {

        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                contentDescription = item.strCategory,
                model = item.strCategoryThumb,
                modifier = Modifier.align(
                    Alignment.CenterHorizontally
                )

            )
            Text(text = item.strCategory)
        }
    }
}
