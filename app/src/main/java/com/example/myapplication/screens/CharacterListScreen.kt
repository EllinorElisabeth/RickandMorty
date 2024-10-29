package com.example.myapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.component.CharacterItem
import com.example.myapplication.shapes.ShapeOne
import com.example.myapplication.ui.RMTheme.BodyTextStyle
import com.example.myapplication.ui.RMTheme.BottomPaddingModifier
import com.example.myapplication.ui.RMTheme.CommonBackgroundColor
import com.example.myapplication.ui.RMTheme.CommonPaddingModifier
import com.example.myapplication.ui.RMTheme.OverlineTextStyle
import com.example.myapplication.ui.RMTheme.StartAndEndPadding16Modifier


@Composable
fun CharacterListScreen(viewModel: CharacterViewModel) {

    val characters by viewModel.characters.collectAsState()
    val favoriteCharacters by viewModel.favoriteCharacters.collectAsState()
    val userInput by viewModel.userInput.collectAsState()

    var input by remember { mutableStateOf("")}

    val filterCharacter = if (userInput.isEmpty()) {
        characters
    } else {
        viewModel.getSearchedCharacters()
    }

    Column(
        modifier = CommonBackgroundColor
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("HOME", style = OverlineTextStyle, modifier = CommonPaddingModifier)
        Text("Check out Rick and Morty characters!", style = BodyTextStyle)

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        LazyColumn {
            item {
                    Text(
                        "Search for character by: name, gender, species, or status (dead/alive).",
                        style = BodyTextStyle,
                        modifier = StartAndEndPadding16Modifier.then(BottomPaddingModifier)
                    )
                    TextField(
                        modifier = Modifier.fillMaxWidth().then(StartAndEndPadding16Modifier),
                        value = input,
                        onValueChange = {
                            input = it
                            viewModel.getUserInput(it)
                        },
                        label = { Text("Search for character...") }
                    )

            }
                items(filterCharacter) { character ->
                    CharacterItem(
                        character = character,
                        onClick = {
                            viewModel.addToFavorites(character)
                        },
                        shape = ShapeOne(),
                        isFavorite = favoriteCharacters.contains(character),
                        addToFavoriteClick = { viewModel.updateFavorite(character) }
                    )
                }
        }

    }
}





