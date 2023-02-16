package com.jairbarzola.yapechallenge.domain.usecase

import com.jairbarzola.yapechallenge.domain.repository.RecipeRepository

class GetRecipeDetailUseCase(
    private val repository: RecipeRepository
) {
    suspend operator fun invoke(id:String) = repository.getRecipeDetail(id)
}