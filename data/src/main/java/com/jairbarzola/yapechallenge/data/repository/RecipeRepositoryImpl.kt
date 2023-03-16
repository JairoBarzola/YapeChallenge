package com.jairbarzola.yapechallenge.data.repository

import com.jairbarzola.yapechallenge.core.common.Failure
import com.jairbarzola.yapechallenge.core.common.Result
import com.jairbarzola.yapechallenge.domain.entity.Recipe
import com.jairbarzola.yapechallenge.domain.entity.RecipeList
import com.jairbarzola.yapechallenge.domain.repository.RecipeRepository

class RecipeRepositoryImpl(
    val apiClient: RecipeApiClient
) : RecipeRepository {
    override suspend fun getRecipesList(): Result<List<RecipeList>, Failure> {

        return try {
            val result = apiClient.getRecipes()
            if (result.isSuccessful) {
                Result.Success(result.body()!!)
            } else {
                Result.Error(Failure.Message("No se pudo obtener las recetas"))
            }

        } catch (t: Throwable) {
            Result.Error(Failure.Exception(t))
        }
    }

    override suspend fun getRecipeDetail(id: String): Result<Recipe, Failure> {
        return try {
            val result = apiClient.getRecipe(id)
            if (result.isSuccessful) {
                Result.Success(result.body()!!)
            } else {
                Result.Error(Failure.Message("No se pudo obtener la receta"))
            }

        } catch (t: Throwable) {
            Result.Error(Failure.Exception(t))
        }
    }
}