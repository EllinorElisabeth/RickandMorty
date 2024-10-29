package com.example.myapplication.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.RMCharacter
import com.example.myapplication.data.RMCharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val _characters = MutableStateFlow<List<RMCharacter>>(emptyList())
    private val _favoriteCharacters = MutableStateFlow<List<RMCharacter>>(emptyList())
    private val _userInput = MutableStateFlow("")

    val characters: StateFlow<List<RMCharacter>> = _characters
    val favoriteCharacters: StateFlow<List<RMCharacter>> = _favoriteCharacters
    val userInput: StateFlow<String> = _userInput

    init {
        getAllCharacters()
    }

    fun getAllCharacters() {
        viewModelScope.launch {
            _characters.value = RMCharacterRepository.getAllCharacter()
        }
    }

    fun addToFavorites(character: RMCharacter) {
        _favoriteCharacters.value += character
    }

    fun removeFromFavorites(character: RMCharacter) {
        _favoriteCharacters.value = _favoriteCharacters.value.toMutableList().apply {
            remove(character)
        }
    }

    fun isFavorite(character: RMCharacter): Boolean {
        return _favoriteCharacters.value.contains(character)
    }

    fun updateFavorite(character: RMCharacter) {
        if (_favoriteCharacters.value.contains(character)) {
            removeFromFavorites(character)
        } else {
            addToFavorites(character)
        }
    }



    fun getUserInput(input: String) {
        _userInput.value = input
    }

    fun getSearchedCharacters(): List<RMCharacter> {
        val userInput = _userInput.value
        return _characters.value.filter { character ->
            character.name.contains(userInput, ignoreCase = true) ||
                    character.gender.contains(userInput, ignoreCase = true) ||
                    character.status.contains(userInput, ignoreCase = true) ||
                    character.species.contains(userInput, ignoreCase = true)
        }
    }


}




