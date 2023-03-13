package com.jairbarzola.yapechallenge.list.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jairbarzola.yapechallenge.list.R
import com.jairbarzola.yapechallenge.designsystem.R as CDS


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchComponent(
    modifier: Modifier = Modifier,
    onSearchListener: (String) -> Unit,
    search: String
) {

    Box(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .shadow(5.dp, RoundedCornerShape(30.dp))
                .background(colorResource(id = CDS.color.bg_search), RoundedCornerShape(30.dp))

                .padding(start = 16.dp, end = 10.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = CDS.drawable.ic_search),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )

                TextField(
                    value = search,
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = {
                        if (it.length <= 20) {
                            onSearchListener(it)
                        }
                    },
                    singleLine = true,
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.search),
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            color = Color.Black.copy(alpha = 0.6f)
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    textStyle = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        color = Color.Black
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        containerColor = Color.Transparent,
                        disabledLabelColor = Color.Gray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    )
                )
            }
        }
    }

}

@Preview
@Composable
fun PreviewSearchComponent() {
    SearchComponent(onSearchListener = {}, search = "")
}