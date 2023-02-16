package com.jairbarzola.yapechallenge.list

import com.jairbarzola.yapechallenge.domain.entity.RecipeList

sealed class RecipeListState {

    object Loading : RecipeListState()
    data class Success(val list: List<RecipeList>) : RecipeListState()
    object Empty : RecipeListState()
    object Error : RecipeListState()
}