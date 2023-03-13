package com.jairbarzola.yapechallenge.detail

import com.jairbarzola.yapechallenge.domain.entity.Recipe

sealed class RecipeDetailState {

    object Loading : RecipeDetailState()
    object Error : RecipeDetailState()
    data class Success(val detail: Recipe) : RecipeDetailState()

}