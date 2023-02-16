package com.jairbarzola.yapechallenge.data.repository

import com.jairbarzola.yapechallenge.core.common.Failure
import com.jairbarzola.yapechallenge.core.common.ResultType
import com.jairbarzola.yapechallenge.domain.entity.Recipe
import com.jairbarzola.yapechallenge.domain.entity.RecipeList
import com.jairbarzola.yapechallenge.domain.repository.RecipeRepository

class RecipeRepositoryImpl(
    val apiClient: RecipeApiClient
) : RecipeRepository {
    override suspend fun getRecipesList(): ResultType<List<RecipeList>, Failure> {

        return try {
            val result = apiClient.getRecipes()
            if (result.isSuccessful) {
                ResultType.Success(result.body()!!)
            } else {
                ResultType.Error(Failure.Message("No se pudo obtener las recetas"))
            }

        } catch (t: Throwable) {
            ResultType.Error(Failure.Exception(t))
        }
    }

    override suspend fun getRecipeDetail(id: String): ResultType<Recipe, Failure> {
        return try {
            val result = apiClient.getRecipe(id)
            if (result.isSuccessful) {
                ResultType.Success(result.body()!!)
            } else {
                ResultType.Error(Failure.Message("No se pudo obtener la receta"))
            }

        } catch (t: Throwable) {
            ResultType.Error(Failure.Exception(t))
        }
    }
}