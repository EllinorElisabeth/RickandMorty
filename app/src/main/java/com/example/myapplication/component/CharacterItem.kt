package com.example.myapplication.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication.data.RMCharacter
import com.example.myapplication.shapes.BackgroundShapeOne
import com.example.myapplication.shapes.BorderShapeOne
import com.example.myapplication.shapes.ShapeOne
import com.example.myapplication.ui.RMTheme.BodyTextStyle


@Composable
fun CharacterItem(
    character: RMCharacter,
    onClick: () -> Unit,
    shape: Shape = ShapeOne(),
    showMoreDetails: Boolean = false
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(
                width = 2.dp,
                color = Color.Magenta,
                shape = BorderShapeOne()
            )
            .clip(shape)
            .background(Color.DarkGray)
            .clickable(onClick = onClick)
    ) {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = character.image),
                    contentDescription = "Character Image",
                    modifier = Modifier
                        .size(68.dp)
                        .padding(4.dp)
                        .clip(CircleShape)
                )
                Column() {
                    Text(
                        text = character.name,
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold

                    )
                    if (showMoreDetails) {
                        Text("Species: ${character.species}", style = BodyTextStyle)
                        Text("Gender: ${character.gender}", style = BodyTextStyle)
                        Text("Status: ${character.status}", style = BodyTextStyle)
                    }
                }

            }


    }
}






