package com.example.myapplication.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
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
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.screens.CharacterListScreen
import com.example.myapplication.screens.CharacterViewModel
import com.example.myapplication.screens.FavoriteCharacter
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
object Favorite


@Composable
fun BottomNavigation( viewModel: CharacterViewModel ) {
    val navController = rememberNavController()
    var selectedValue by rememberSaveable {
        mutableStateOf(0)
    }

    Scaffold(

        bottomBar = {
            NavigationBar(
                containerColor = Color.Yellow
            ) {
                NavigationBarItem(
                    selectedValue == 0,
                    onClick = {
                        selectedValue = 0
                        navController.navigate(CharacterList)
                    },
                    icon = {
                        Icon(
                            if (selectedValue == 0) Icons.Filled.Home else Icons.Outlined.Home, "null",
                            tint = if (selectedValue == 0) Color.Black else Color.Gray
                        )
                    },
                    label = {
                        Text(
                            "Home",
                            color = if (selectedValue == 0) Color.Black else Color.Gray
                        )
                    }
                )

                NavigationBarItem(
                    selectedValue == 1,
                    onClick = {
                        selectedValue = 1
                        navController.navigate(MyCharacter)
                    },
                    icon = {
                        Icon(
                            if (selectedValue == 1) Icons.Filled.Face else Icons.Outlined.Face, "null",
                            tint = if (selectedValue == 1) Color.Black else Color.Gray
                        )
                    },
                    label = {
                        Text(
                            "Characters",
                            color = if (selectedValue == 1) Color.Black else Color.Gray
                        )
                    }
                )

                NavigationBarItem(
                    selectedValue == 2,
                    onClick = {
                        selectedValue = 2
                        navController.navigate(CreateCharacter)
                    },
                    icon = {
                        Icon(
                            if (selectedValue == 2) Icons.Filled.AddCircle else Icons.Outlined.Add, "null",
                            tint = if (selectedValue == 2) Color.Black else Color.Gray
                        )
                    },
                    label = {
                        Text(
                            "Create",
                            color = if (selectedValue == 2) Color.Black else Color.Gray
                        )
                    }
                )

                NavigationBarItem(
                    selectedValue == 3,
                    onClick = {
                        selectedValue = 3
                        navController.navigate(Favorite)
                    },
                    icon = {
                        Icon(
                            if (selectedValue == 3) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder, "null",
                            tint = if (selectedValue == 3) Color.Black else Color.Gray
                        )
                    },
                    label = {
                        Text(
                            "Favorite",
                            color = if (selectedValue == 3) Color.Black else Color.Gray
                        )
                    }
                )
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
                composable<Favorite> {
                    FavoriteCharacter(viewModel)
                }
            }
        }
    }
}
