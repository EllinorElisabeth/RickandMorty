package com.example.myapplication.shapes

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class BorderShapeOne : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(Path().apply {
            moveTo(0f, 0f)
            lineTo(size.width - -10f, 20f)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        })
    }
}

@Composable
fun BorderOne() {
    Box(
        modifier = Modifier
            .clip(BorderShapeOne())
    )
}