package com.jairbarzola.yapechallenge.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jairbarzola.yapechallenge.designsystem.R

@Composable
fun IngredientComponent(position: Int, quantity: String, name: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        Box(
            modifier =
            Modifier
                .clip(CircleShape)
                .size(20.dp)
                .border(1.dp, colorResource(id = R.color.purple_500), CircleShape)
                .background(Color.White)
        ) {

            Text(
                text = "$position", style = TextStyle(
                    color = colorResource(id = R.color.purple_500),
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                ),
                modifier = Modifier
                    .align(Alignment.Center)
            )

        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = quantity, style = TextStyle(
                color = Color.Black, fontWeight = FontWeight.Normal, fontSize = 16.sp
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = name, style = TextStyle(
                color = Color.Black, fontWeight = FontWeight.Normal, fontSize = 16.sp
            )
        )

    }
}

@Preview
@Composable
fun PreviewIngredient() {
    IngredientComponent(position = 1, quantity = "2", name = "tomates")
}