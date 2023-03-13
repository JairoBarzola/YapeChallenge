package com.jairbarzola.yapechallenge.data.repository

import com.jairbarzola.yapechallenge.domain.entity.Recipe
import com.jairbarzola.yapechallenge.domain.entity.RecipeList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApiClient {

    @GET("recipes")
    suspend fun getRecipes(): Response<List<RecipeList>>

    @GET("recipe")
    suspend fun getRecipe(
        @Query("id") id: String
    ): Response<Recipe>
}