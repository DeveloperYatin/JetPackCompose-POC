package com.dev.samples.sample.ui.navigationScreens

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

const val loadingScreen = "loading"
const val mainScreen = "main_screen"
const val shimmerScreen = "shimmer_screen"
const val errorScreen = "error_screen"

@Composable
fun Navigation(context: Context) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = loadingScreen
    ) {
        composable(loadingScreen) {
            FullScreenLoading(navController)
        }
        // Main Screen
        composable(mainScreen) {
            MyContentScreen(navController)
        }

        // Shimmer Screen
        composable(shimmerScreen) {
            ShimmerScreenLoading(navController)
        }

        //Error Screen
        composable(errorScreen) {
            ErrorScreen {
                Toast.makeText(context,"Take me to store button clicked",Toast.LENGTH_LONG).show()
                navController.navigate(shimmerScreen)
            }
        }
    }
}