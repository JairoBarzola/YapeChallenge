package com.jairbarzola.yapechallenge.map

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

object MapNavigation {
    const val route = "map"
    const val latitude = "latitude"
    const val longitude = "longitude"
    const val fullRoute = "$route/{$latitude}/{$longitude}"
}

fun NavGraphBuilder.mapScreen(
    navigateToBack: () -> Unit
) {
    composable(MapNavigation.fullRoute) { backStackEntry ->
        MapScreen(
            navigateToBack = { navigateToBack() },
            latitude = backStackEntry.arguments?.getString(MapNavigation.latitude)?.toDouble() ?: 0.0,
            longitude = backStackEntry.arguments?.getString(MapNavigation.longitude)?.toDouble() ?: 0.0
        )
    }
}