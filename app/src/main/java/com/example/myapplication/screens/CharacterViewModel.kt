package com.example.myapplication.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.RMCharacter
import com.example.myapplication.data.RMCharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val _favoriteCharacters = MutableStateFlow<List<RMCharacter>>(emptyList())
    val favoriteCharacters: StateFlow<List<RMCharacter>> = _favoriteCharacters

    fun addToFavorites(character: RMCharacter) {
        _favoriteCharacters.value = _favoriteCharacters.value + character
    }

    fun removeFromFavorites(character: RMCharacter) {
        _favoriteCharacters.value =_favoriteCharacters.value.toMutableList().apply {
            remove(character)
        }
    }


}



