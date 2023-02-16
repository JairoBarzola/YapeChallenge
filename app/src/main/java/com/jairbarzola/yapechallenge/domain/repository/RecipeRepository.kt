package com.jairbarzola.yapechallenge.domain.repository

import com.jairbarzola.yapechallenge.core.common.Failure
import com.jairbarzola.yapechallenge.core.common.ResultType
import com.jairbarzola.yapechallenge.domain.entity.Recipe
import com.jairbarzola.yapechallenge.domain.entity.RecipeList

interface RecipeRepository {
    suspend fun getRecipesList(): ResultType<List<RecipeList>, Failure>
    suspend fun getRecipeDetail(id: String): ResultType<Recipe, Failure>
}