package com.jairbarzola.yapechallenge.domain.repository

import com.jairbarzola.yapechallenge.core.common.Failure
import com.jairbarzola.yapechallenge.core.common.Result
import com.jairbarzola.yapechallenge.domain.entity.Recipe
import com.jairbarzola.yapechallenge.domain.entity.RecipeList

interface RecipeRepository {
    suspend fun getRecipesList(): Result<List<RecipeList>, Failure>
    suspend fun getRecipeDetail(id: String): Result<Recipe, Failure>
}