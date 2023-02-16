package com.jairbarzola.yapechallenge.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jairbarzola.yapechallenge.R
import com.jairbarzola.yapechallenge.data.fake.FakeDataSource
import com.jairbarzola.yapechallenge.domain.entity.RecipeList
import com.jairbarzola.yapechallenge.list.component.ItemComponent
import com.jairbarzola.yapechallenge.list.component.SearchComponent

@Composable
fun RecipeListScreen(
    viewModel: RecipeListViewModel = hiltViewModel(), navigateToDetail: (String) -> Unit
) {
    val screenState = viewModel.screenState.collectAsState().value
    when (screenState) {

        is RecipeListState.Loading -> {
            RecipeListLoading()
        }

        is RecipeListState.Success -> {
            RecipeListContent(
                recipeList = screenState.list,
                navigateToDetail = { navigateToDetail(it) },
                onSearchRecipes = { viewModel.searchRecipes(it) })
        }

        is RecipeListState.Empty -> {
            RecipeListEmpty(getRecipeList = { viewModel.getRecipeList() })
        }

        is RecipeListState.Error -> {
            RecipeListError(getRecipeList = { viewModel.getRecipeList() })
        }
    }
}

@Composable
fun RecipeListLoading() {
    Box(modifier = Modifier
        .fillMaxSize()
        .semantics { contentDescription = "Loading Indicator" }) {
        CircularProgressIndicator(Modifier.align(Alignment.Center))
    }
}

@Composable
fun RecipeListEmpty(
    getRecipeList: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .semantics { contentDescription = "Empty Indicator" },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.list_empty_title), style = TextStyle(
                color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { getRecipeList() },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Reintentar"
            )
        }
    }
}

@Composable
fun RecipeListError(
    getRecipeList: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .semantics { contentDescription = "Error Indicator" },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.list_error_title), style = TextStyle(
                color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { getRecipeList() },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Reintentar"
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeListContent(
    recipeList: List<RecipeList>, navigateToDetail: (String) -> Unit,
    onSearchRecipes: (String) -> Unit
) {

    val scrollableState = rememberLazyGridState()
    var search by rememberSaveable  { mutableStateOf("") }

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .semantics { contentDescription = "Content Indicator" }) {
        Column(modifier = Modifier.padding(it)) {

            SearchComponent(
                onSearchListener = {
                    search = it
                    onSearchRecipes(it)
                }, modifier = Modifier.padding(16.dp),
                search = search
            )

            LazyVerticalGrid(
                columns = GridCells.Adaptive(120.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                state = scrollableState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                recipeList.forEach {
                    item {
                        ItemComponent(recipe = it, onClickItem = {
                            navigateToDetail(it)
                        })
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewRecipeListContent() {
    RecipeListContent(recipeList = FakeDataSource.list, navigateToDetail = {}, onSearchRecipes = {})
}