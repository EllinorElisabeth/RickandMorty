package com.example.myapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.component.CharacterItem
import com.example.myapplication.data.RMCharacter
import com.example.myapplication.data.RMCharacterRepository
import com.example.myapplication.shapes.ShapeOne
import com.example.myapplication.ui.RMTheme.BottomPaddingModifier
import com.example.myapplication.ui.RMTheme.CenterModifier
import com.example.myapplication.ui.RMTheme.CommonBackgroundColor
import com.example.myapplication.ui.RMTheme.CommonPaddingModifier
import com.example.myapplication.ui.RMTheme.OverlineTextStyle
import com.example.myapplication.ui.RMTheme.TitleBackgroundModifier
import com.example.myapplication.ui.RMTheme.TitleStyle


@Composable
fun CharacterListScreen(viewModel: CharacterViewModel) {

    var characters by remember {
        mutableStateOf<List<RMCharacter>>(emptyList())
    }

    LaunchedEffect(Unit) {
        characters = RMCharacterRepository.getAllCharacter()
    }

    Column(
        modifier = CommonBackgroundColor
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("HOME", style = OverlineTextStyle, modifier = CommonPaddingModifier)
        Text("Rick and Morty character list", style = TitleStyle, modifier = TitleBackgroundModifier.then(
            CenterModifier))

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        LazyColumn {

                items(characters) { character ->
                    CharacterItem(
                        character = character,
                        onClick = {
                            viewModel.addToFavorites(character)
                        },
                        shape = ShapeOne()
                    )
                }
        }

    }
}




