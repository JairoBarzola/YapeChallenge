package com.jairbarzola.yapechallenge.domain.usecase

import com.jairbarzola.yapechallenge.domain.repository.RecipeRepository

class GetRecipeListUseCase(
    private val repository: RecipeRepository
) {
    suspend operator fun invoke() = repository.getRecipesList()
}