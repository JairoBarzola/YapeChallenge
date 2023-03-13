package com.jairbarzola.yapechallenge.detail

import androidx.lifecycle.SavedStateHandle
import com.jairbarzola.yapechallenge.core.common.Failure
import com.jairbarzola.yapechallenge.core.common.ResultType
import com.jairbarzola.yapechallenge.detail.helper.detailHelper
import com.jairbarzola.yapechallenge.detail.navigation.RecipeDetailNavigation
import com.jairbarzola.yapechallenge.domain.usecase.GetRecipeDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.whenever

class RecipeDetailViewModelTest {

    private val getRecipeDetailUseCase = Mockito.mock(GetRecipeDetailUseCase::class.java)
    private lateinit var viewModel: RecipeDetailViewModel


    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when instantiated, screen state should be loading`() = runBlocking {
        //Arrange
        //Act
        viewModel = RecipeDetailViewModel(
            getRecipeDetailUseCase = getRecipeDetailUseCase,
            savedStateHandle = SavedStateHandle(),
            coroutineDispatcher = Dispatchers.Unconfined
        )
        //Assert
        Assert.assertEquals(
            RecipeDetailState.Loading::class.java.simpleName,
            viewModel.screenState.value.javaClass.simpleName
        )
    }

    @Test
    fun `when getRecipeDetail returns ResultSuccess, then screen state should be Success`() =
        runBlocking {
            //Arrange
            val id = "1"
            val savedStateHandle = SavedStateHandle().apply {
                set(RecipeDetailNavigation.id, id)
            }
            whenever(getRecipeDetailUseCase(id)).thenReturn(
                ResultType.Success(detailHelper)
            )
            //Act
            viewModel = RecipeDetailViewModel(
                getRecipeDetailUseCase = getRecipeDetailUseCase,
                savedStateHandle = savedStateHandle,
                coroutineDispatcher = Dispatchers.Unconfined
            )
            viewModel.getRecipeDetail()
            //Assert
            Assert.assertEquals(
                RecipeDetailState.Success::class.java.simpleName,
                viewModel.screenState.value.javaClass.simpleName
            )
        }


    @Test
    fun `when getRecipeDetail returns ResultError, then screen state should be Error`() =
        runBlocking {
            //Arrange
            val id = "1"
            val savedStateHandle = SavedStateHandle().apply {
                set(RecipeDetailNavigation.id, id)
            }
            whenever(getRecipeDetailUseCase(id)).thenReturn(
                ResultType.Error(Failure.Message("No se pudo obtener la receta"))
            )
            //Act
            viewModel = RecipeDetailViewModel(
                getRecipeDetailUseCase = getRecipeDetailUseCase,
                savedStateHandle = savedStateHandle,
                coroutineDispatcher = Dispatchers.Unconfined
            )
            viewModel.getRecipeDetail()
            //Assert
            Assert.assertEquals(
                RecipeDetailState.Error::class.java.simpleName,
                viewModel.screenState.value.javaClass.simpleName
            )
        }
}