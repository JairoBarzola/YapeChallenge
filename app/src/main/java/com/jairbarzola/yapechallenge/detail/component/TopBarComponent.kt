package com.jairbarzola.yapechallenge.detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jairbarzola.yapechallenge.R

@Composable
fun TopBarComponent(
    onBack: () -> Unit,
    onMap: () -> Unit,
    name: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .padding(start = 16.dp, end = 16.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Image(painter = painterResource(id = R.drawable.ic_arrow_left), contentDescription = null,
            modifier = Modifier
                .size(25.dp)
                .clickable {
                    onBack()
                })

        Text(
            text = name, style = TextStyle(
                fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black
            ), modifier = Modifier
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.height(54.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.ic_navigation),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .clickable {
                        onMap()
                    })
        }
    }
}

@Preview
@Composable
fun PreviewTopBar() {
    TopBarComponent(onBack = {}, name = "Ensalada de Betarraga", onMap = {})
}