package com.jairbarzola.yapechallenge.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.jairbarzola.yapechallenge.detail.navigation.RecipeDetailNavigation
import com.jairbarzola.yapechallenge.detail.navigation.detailScreen
import com.jairbarzola.yapechallenge.list.navigation.RecipeListNavigation
import com.jairbarzola.yapechallenge.list.navigation.listScreen
import com.jairbarzola.yapechallenge.map.MapNavigation
import com.jairbarzola.yapechallenge.map.mapScreen

@Composable
fun MainNavHost(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController, startDestination = RecipeListNavigation.route,
        modifier = modifier
    ) {
        listScreen(
            navigateToDetail = {
                navHostController.navigate(
                    "${RecipeDetailNavigation.route}/$it"
                )
            }
        )
        detailScreen(
            navigateToMap = {lat, long->
                navHostController.navigate("${MapNavigation.route}/$lat/$long")
            },
            navigateToBack = {navHostController.popBackStack()}

        )
        mapScreen(
            navigateToBack = {navHostController.popBackStack()}
        )
    }
}