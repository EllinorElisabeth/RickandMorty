package com.example.myapplication.ui.RMTheme

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val LeftPaddingModifier = Modifier.padding(start = 16.dp)
val StartAndEndPadding8Modifier = Modifier.padding(start = 8.dp, end = 8.dp)
val StartAndEndPadding16Modifier = Modifier.padding(start = 16.dp, end = 16.dp)

val BottomPaddingModifier = Modifier.padding(bottom = 8.dp)

val CommonPaddingModifier = Modifier.padding(24.dp)

val CenterModifier = Modifier
    .fillMaxWidth()
    .wrapContentWidth(Alignment.CenterHorizontally)
    .padding(24.dp)

val TitleStyle = TextStyle (
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
    letterSpacing = 0.8.sp,
    color = Color.Black,
    textAlign = TextAlign.Center
)

val OverlineTextStyle = TextStyle (
    color = Color.LightGray,
    fontSize = 14.sp,
    fontWeight = FontWeight.W700,
    letterSpacing = 0.8.sp,
)

val BodyTextStyle = TextStyle (
    fontSize = 18.sp,
    letterSpacing = 0.6.sp,
    color = Color.LightGray
)

val CommonBackgroundColor = Modifier
    .fillMaxWidth()
    .background(Color.Black)

val TitleBackgroundModifier = Modifier
    .fillMaxWidth()
    .background(Color.Yellow)
