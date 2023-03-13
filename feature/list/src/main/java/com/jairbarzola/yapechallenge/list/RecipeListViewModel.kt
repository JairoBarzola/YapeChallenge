package com.jairbarzola.yapechallenge.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jairbarzola.yapechallenge.core.common.ResultType
import com.jairbarzola.yapechallenge.core.common.StringUtils.unaccent
import com.jairbarzola.yapechallenge.domain.entity.Ingredient
import com.jairbarzola.yapechallenge.domain.entity.RecipeList
import com.jairbarzola.yapechallenge.domain.usecase.GetRecipeListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    val getRecipeListUseCase: GetRecipeListUseCase,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {


    private val _screenState = MutableStateFlow<RecipeListState>(RecipeListState.Loading)
    val screenState: StateFlow<RecipeListState> get() = _screenState

    private var recipeList = listOf<RecipeList>()

    init {
        getRecipeList()
    }

    fun getRecipeList() {
        viewModelScope.launch(coroutineDispatcher) {

            _screenState.value = RecipeListState.Loading

            when (val result = getRecipeListUseCase()) {
                is ResultType.Success -> {
                    if (result.value.isEmpty()) {
                        _screenState.value = RecipeListState.Empty
                    } else {
                        recipeList = result.value
                        _screenState.value = RecipeListState.Success(result.value)
                    }
                }
                is ResultType.Error -> {
                    _screenState.value = RecipeListState.Error
                }
            }

        }
    }

    fun searchRecipes(query: String) {
        viewModelScope.launch(coroutineDispatcher) {
            if (query.isEmpty()) {
                _screenState.value = RecipeListState.Success(recipeList)
                return@launch
            }
            val results = recipeList.filter {
                it.name.unaccent().contains(query.trim().unaccent(), ignoreCase = true)
                        || searchInIngredients(it.ingredients, query.trim().unaccent())
            }

            _screenState.value = RecipeListState.Success(results)
        }
    }

    private fun searchInIngredients(ingredients: List<Ingredient>, query: String): Boolean {
        return ingredients.firstOrNull { it.name.unaccent().contains(query) } != null
    }
}