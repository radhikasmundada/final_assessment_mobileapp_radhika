package com.example.final_assessment_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.final_assessment_kotlin.ui.theme.FinalassessmentkotlinTheme
import com.example.final_assessment_kotlin.ui.theme.screens.DishDetailsScreen
import com.example.final_assessment_kotlin.ui.theme.screens.DishScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Routing()
        }
    }
}


@Composable
fun Routing() {
    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = "dishscreen") {

        composable(route = "dishscreen") {
            DishScreen(navController)
        }

        composable(
            route = "DishDetailScreen/{id}",                                 // need to mention  an argument of named name, email in curly brackets
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }    // Pass your arguments here with name given in route
            )
        ) {
            var id = it.arguments?.getInt("id")
            id?.let {
               DishDetailsScreen(navController = navController, id = id)
            }
        }
    }
}