package com.example.myapplication.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.screens.CharacterListScreen
import com.example.myapplication.screens.CharacterViewModel
import com.example.myapplication.screens.ScreenFour
import com.example.myapplication.screens.ScreenThree
import com.example.myapplication.screens.ScreenTwo
import kotlinx.serialization.Serializable

@Serializable
object CharacterList

@Serializable
object MyCharacter

@Serializable
object CreateCharacter

@Serializable
object Undefined

@Composable
fun AppNavigation( viewModel: CharacterViewModel ) {
    val navController = rememberNavController()
    var selectedIndex by rememberSaveable {
        mutableStateOf(0)
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(CharacterList)
                    },
                    icon = {
                        if (selectedIndex == 0) {
                            Icon(
                                imageVector = Icons.Filled.Home, contentDescription = null
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Outlined.Home, contentDescription = null
                            )
                        }
                    },
                    label = {
                        Text(text = "Home")
                    }
                ) // End: CharacterList

                NavigationBarItem(
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        navController.navigate(MyCharacter)
                    },
                    icon = {
                        if (selectedIndex == 1) {
                            Icon(
                                imageVector = Icons.Filled.Home, contentDescription = null
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Outlined.Home, contentDescription = null
                            )
                        }
                    },
                    label = {
                        Text(text = "Characters")
                    }
                ) // End: MyCharacters (in database)

                NavigationBarItem(
                    selected = selectedIndex == 2,
                    onClick = {
                        selectedIndex = 2
                        navController.navigate(CreateCharacter)
                    },
                    icon = {
                        if (selectedIndex == 2) {
                            Icon(
                                imageVector = Icons.Filled.Home, contentDescription = null
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Outlined.Home, contentDescription = null
                            )
                        }
                    },
                    label = {
                        Text(text = "Create")
                    }
                ) // End: Create character

                NavigationBarItem(
                    selected = selectedIndex == 3,
                    onClick = {
                        selectedIndex = 3
                        navController.navigate(Undefined)
                    },
                    icon = {
                        if (selectedIndex == 3) {
                            Icon(
                                imageVector = Icons.Filled.Home, contentDescription = null
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Outlined.Home, contentDescription = null
                            )
                        }
                    },
                    label = {
                        Text(text = "Favorites")
                    }
                ) // End: Ekstra
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = CharacterList
            ) {
                composable<CharacterList> {
                    CharacterListScreen(viewModel)
                }
                composable<MyCharacter> {
                    ScreenTwo()
                }
                composable<CreateCharacter> {
                    ScreenThree()
                }
                composable<Undefined> {
                    ScreenFour(viewModel)
                }
            }
        }
    }
}

