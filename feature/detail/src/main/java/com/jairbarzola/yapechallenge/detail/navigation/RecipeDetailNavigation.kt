package com.jairbarzola.yapechallenge.detail.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jairbarzola.yapechallenge.detail.RecipeDetailScreen

object RecipeDetailNavigation {
    const val route = "detail"
    const val id = "id"
    const val fullRoute = "$route/{$id}"
}

fun NavGraphBuilder.detailScreen(
    navigateToMap: (Double, Double) -> Unit,
    navigateToBack: () -> Unit
) {
    composable(
        route = RecipeDetailNavigation.fullRoute,
        arguments = listOf(
            navArgument(RecipeDetailNavigation.id) { type = NavType.StringType }
        )
    ) {
        RecipeDetailScreen(
            navigateToBack = {navigateToBack()},
            navigateToMap = { lat, long -> navigateToMap(lat, long)}
        )
    }
}