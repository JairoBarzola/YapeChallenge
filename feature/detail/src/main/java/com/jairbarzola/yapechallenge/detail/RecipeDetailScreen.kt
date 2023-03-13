package com.jairbarzola.yapechallenge.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.jairbarzola.yapechallenge.detail.component.IngredientComponent
import com.jairbarzola.yapechallenge.detail.component.InstructionComponent
import com.jairbarzola.yapechallenge.detail.component.TopBarComponent
import com.jairbarzola.yapechallenge.detail.helper.detailHelper
import com.jairbarzola.yapechallenge.domain.entity.Recipe

@Composable
fun RecipeDetailScreen(
    viewModel: RecipeDetailViewModel = hiltViewModel(),
    navigateToMap: (Double, Double) -> Unit,
    navigateToBack: () -> Unit
) {

    val screenState = viewModel.screenState.collectAsState().value

    when (screenState) {
        is RecipeDetailState.Loading -> {
            RecipeDetailLoading()
        }
        is RecipeDetailState.Error -> {
            RecipeDetailError {
                viewModel.getRecipeDetail()
            }
        }
        is RecipeDetailState.Success -> {
            RecipeDetailContent(recipe = screenState.detail,
                navigateToBack = { navigateToBack() },
                navigateToMap = { lat, long -> navigateToMap(lat, long) })
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailContent(
    recipe: Recipe, navigateToBack: () -> Unit, navigateToMap: (Double, Double) -> Unit
) {

    val scrollState = rememberScrollState()

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .semantics { contentDescription = "Content Indicator" },

        topBar = {
            TopBarComponent(onBack = { navigateToBack() },
                onMap = { navigateToMap(recipe.location.latitude, recipe.location.longitude) },
            name = recipe.name)
        }) {

        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current).data(recipe.image)
                .size(Size.ORIGINAL).build()
        )

        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(scrollState)
        ) {

                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.1f),
                    contentScale = ContentScale.Crop
                )
            Column(
                modifier = Modifier.padding(
                    top = 16.dp, start = 16.dp, end = 16.dp, bottom = 16.dp
                )
            ) {
                Text(
                    text = recipe.description, style = TextStyle(
                        fontSize = 14.sp, fontWeight = FontWeight.Normal, color = Color.Black
                    )
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = stringResource(id = R.string.ingredients), style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black
                            ), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = "${recipe.ingredients.size}", style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black
                            ), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()
                        )
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = stringResource(id = R.string.time), style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black
                            ), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = "${recipe.time} min", style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black
                            ), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()
                        )
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = stringResource(id = R.string.difficulty),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = "${recipe.difficulty}/${stringResource(id = R.string.max_difficulty)}", style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black
                            ), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.Gray.copy(alpha = 0.2f))
            ) {
                Text(
                    text = stringResource(id = R.string.ingredients) , style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black.copy(.3f)
                    ), modifier = Modifier
                        .align(Alignment.Center)
                        .padding(8.dp)
                )
            }

            recipe.ingredients.forEachIndexed { index, ingredient ->

                IngredientComponent(
                    position = index + 1, quantity = ingredient.quantity, name = ingredient.name
                )

            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.Gray.copy(alpha = 0.2f))
            ) {
                Text(
                    text = stringResource(id = R.string.instructions), style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black.copy(.3f)
                    ), modifier = Modifier
                        .align(Alignment.Center)
                        .padding(8.dp)
                )
            }

            recipe.instructions.forEachIndexed { index, str ->

                InstructionComponent(
                    position = index + 1, name = str
                )
            }
        }
    }
}

@Composable
fun RecipeDetailError(
    retryAgain: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .semantics { contentDescription = "Error Indicator" },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.detail_empty_title), style = TextStyle(
                color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { retryAgain() }, colors = ButtonDefaults.buttonColors(
                contentColor = Color.White
            )
        ) {
            Text(
                text = stringResource(id = R.string.retry)
            )
        }
    }
}

@Composable
fun RecipeDetailLoading() {
    Box(modifier = Modifier
        .fillMaxSize()
        .semantics { contentDescription = "Loading Indicator" }) {
        CircularProgressIndicator(Modifier.align(Alignment.Center))
    }
}

@Preview
@Composable
fun PreviewRecipeDetail() {
    RecipeDetailContent(recipe = detailHelper,
        navigateToBack = { },
        navigateToMap = { lat, long ->
        })
}