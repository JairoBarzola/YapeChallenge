package com.jairbarzola.yapechallenge.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jairbarzola.yapechallenge.detail.navigation.RecipeDetailNavigation
import com.jairbarzola.yapechallenge.domain.usecase.GetRecipeDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.jairbarzola.yapechallenge.core.common.Result

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    val getRecipeDetailUseCase: GetRecipeDetailUseCase,
    savedStateHandle: SavedStateHandle,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _screenState = MutableStateFlow<RecipeDetailState>(RecipeDetailState.Loading)
    val screenState: StateFlow<RecipeDetailState> get() = _screenState

    private val recipeId: String? = savedStateHandle[RecipeDetailNavigation.id]

    init {
        getRecipeDetail()
    }

    fun getRecipeDetail() {
        viewModelScope.launch(coroutineDispatcher) {
            _screenState.value = RecipeDetailState.Loading

            when (val result = getRecipeDetailUseCase(recipeId.orEmpty())){
                is Result.Success ->{
                    _screenState.value = RecipeDetailState.Success(result.value)
                }
                is Result.Error ->{
                    _screenState.value = RecipeDetailState.Error
                }
            }
        }
    }
}