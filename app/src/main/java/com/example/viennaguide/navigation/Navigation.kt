package com.example.viennaguide.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.viennaguide.screens.CategoriesScreen
import com.example.viennaguide.screens.PlacesScreen
import com.example.viennaguide.screens.DetailsScreen

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "categories") {
        composable(route = "categories") {
            CategoriesScreen(navController)
        }
        composable(route = "places/{category}") { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category") ?: ""
            PlacesScreen(category, navController)
        }
        composable(route = "details/{placeId}") { backStackEntry ->
            val placeId = backStackEntry.arguments?.getString("placeId")?.toIntOrNull() ?: 0
            DetailsScreen(placeId, navController)
        }
    }
}
