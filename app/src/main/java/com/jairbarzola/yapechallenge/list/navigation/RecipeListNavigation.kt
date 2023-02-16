package com.jairbarzola.yapechallenge.list.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jairbarzola.yapechallenge.list.RecipeListScreen

object RecipeListNavigation {
    const val route = "list"
}

fun NavGraphBuilder.listScreen(
    navigateToDetail: (String) -> Unit
){
    composable(RecipeListNavigation.route){
        RecipeListScreen(
            navigateToDetail = { navigateToDetail(it) }
        )
    }
}