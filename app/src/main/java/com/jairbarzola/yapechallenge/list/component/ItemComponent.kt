package com.jairbarzola.yapechallenge.list.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.jairbarzola.yapechallenge.domain.entity.RecipeList

@Composable
fun ItemComponent(
    recipe: RecipeList,
    onClickItem: (String) -> Unit
) {

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(recipe.image)
            .size(Size.ORIGINAL)
            .build()
    )

    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        modifier = Modifier
            .width(120.dp)
            .clickable {
                onClickItem(recipe.id)
            }
    ) {

        Column {
            Image(
                painter = painter, contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop,
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp).height(40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = recipe.name,
                    style = TextStyle(fontSize = 17.sp, fontWeight = FontWeight.Medium,
                    color = Color.Black),
                    maxLines = 2,
                    modifier = Modifier
                        .weight(.8f)

                )


                Text(
                    text = "${recipe.time} min",
                    style = TextStyle(
                        fontSize = 12.sp, fontWeight = FontWeight.Normal,
                        color = Color.Black.copy(alpha = 0.5f)
                    ),
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .weight(.2f)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Preview
@Composable
fun PreviewItemComponent() {
    ItemComponent(recipe = RecipeList(
        "1",
        "Receta Ensalada de Betarraga",
        40,
        image = "",
        ingredients = listOf()
    ), onClickItem = {})
}