package com.stasst.composenavigationlesson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.stasst.composenavigationlesson.screens.DetailsScreen
import com.stasst.composenavigationlesson.screens.ListScreen
import com.stasst.composenavigationlesson.screens.PushScreen
import com.stasst.composenavigationlesson.screens.SearchScreen
import com.stasst.composenavigationlesson.ui.theme.ComposeNavigationLessonTheme
import com.stasst.composenavigationlesson.util.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationLessonTheme(darkTheme = false) {
                Surface(color = MaterialTheme.colors.background){
                    var navController = rememberNavController()
                    val bottomItems = listOf("List", "Search", "Push")

                    Scaffold(
                        bottomBar = {
                            BottomNavigation {
                                bottomItems.forEach{ screen ->
                                    BottomNavigationItem(
                                        selected = false,
                                        onClick = {
                                            navController.navigate(screen)
                                        },
                                        label = { Text(screen) },
                                        icon = {

                                        }
                                    )
                                }
                            }
                        }
                    ) {padding ->
                        NavHost(startDestination = "List", navController = navController, modifier = Modifier.padding(0.dp)){
                            composable(Screen.ListScreen.route){ ListScreen(navController) }
                            composable(Screen.SearchScreen.route){ SearchScreen() }
                            composable(Screen.PushScreen.route){ PushScreen() }
                            composable(
                                route = Screen.DetailsScreen.route,
                                arguments = listOf(
                                    navArgument("name"){
                                        type = NavType.StringType
                                    }
                                )
                            ) {
                                val name = it.arguments?.getString("name")
                                DetailsScreen(name = name)
                            }
                        }
                    }
                }
            }
        }
    }
}
