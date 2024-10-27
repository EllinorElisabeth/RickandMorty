package com.example.myapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapplication.component.CharacterItem
import com.example.myapplication.shapes.ShapeTwo
import com.example.myapplication.ui.RMTheme.BottomPaddingModifier
import com.example.myapplication.ui.RMTheme.CenterModifier
import com.example.myapplication.ui.RMTheme.CommonBackgroundColor
import com.example.myapplication.ui.RMTheme.CommonPaddingModifier
import com.example.myapplication.ui.RMTheme.OverlineTextStyle
import com.example.myapplication.ui.RMTheme.TitleBackgroundModifier
import com.example.myapplication.ui.RMTheme.TitleStyle

@Composable
fun ScreenFour(viewModel: CharacterViewModel) {

    val favoriteCharacters by viewModel.favoriteCharacters.collectAsState()

    Column(
        modifier = CommonBackgroundColor
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("FAVORITES", style = OverlineTextStyle, modifier = CommonPaddingModifier)
        Text("Rick and Morty favorite characters",
            style = TitleStyle,
            modifier = TitleBackgroundModifier.then(CommonPaddingModifier))

        LazyColumn {
            items(favoriteCharacters) { character ->
                CharacterItem(
                    character = character,
                    onClick = {
                        viewModel.removeFromFavorites(character)
                    },
                    showMoreDetails = true,
                    shape = ShapeTwo()
                )

            }
        }
    }
}