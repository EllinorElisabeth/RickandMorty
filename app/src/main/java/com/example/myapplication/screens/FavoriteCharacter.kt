package com.example.myapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import com.example.myapplication.component.CharacterItem
import com.example.myapplication.shapes.ShapeTwo
import com.example.myapplication.ui.RMTheme.CommonBackgroundColor
import com.example.myapplication.ui.RMTheme.CommonPaddingModifier
import com.example.myapplication.ui.RMTheme.OverlineTextStyle
import com.example.myapplication.ui.RMTheme.TitleBackgroundModifier
import com.example.myapplication.ui.RMTheme.TitleStyle

@Composable
fun FavoriteCharacter(viewModel: CharacterViewModel) {

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
                    shape = ShapeTwo(),
                    showMoreDetails = true,
                    addToFavoriteClick = {
                        if (viewModel.isFavorite(character)) {
                            viewModel.removeFromFavorites(character)
                        } else {
                            viewModel.addToFavorites(character)
                        }
                    },
                    isFavorite = favoriteCharacters.contains(character)
                )

            }
        }
    }
}