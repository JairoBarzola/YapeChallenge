package com.jairbarzola.yapechallenge.viewmodel

import com.jairbarzola.yapechallenge.core.common.Failure
import com.jairbarzola.yapechallenge.core.common.ResultType
import com.jairbarzola.yapechallenge.data.fake.FakeDataSource
import com.jairbarzola.yapechallenge.domain.usecase.GetRecipeListUseCase
import com.jairbarzola.yapechallenge.list.RecipeListState
import com.jairbarzola.yapechallenge.list.RecipeListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

class RecipeListViewModelTest {

    private val getRecipeListUseCase = mock(GetRecipeListUseCase::class.java)
    private lateinit var viewModel: RecipeListViewModel

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
        viewModel = RecipeListViewModel(getRecipeListUseCase, Dispatchers.Unconfined)
        //Assert
        assertEquals(
            RecipeListState.Loading::class.java.simpleName,
            viewModel.screenState.value.javaClass.simpleName
        )
    }

    @Test
    fun `when getRecipeList returns ResultSuccess, then screen state should be Success`() =
        runBlocking {
            //Arrange
            whenever(getRecipeListUseCase()).thenReturn(
                ResultType.Success(FakeDataSource.list)
            )
            //Act
            viewModel = RecipeListViewModel(getRecipeListUseCase, Dispatchers.Unconfined)
            viewModel.getRecipeList()
            //Assert
            assertEquals(
                RecipeListState.Success::class.java.simpleName,
                viewModel.screenState.value.javaClass.simpleName
            )
        }


    @Test
    fun `when getRecipeList returns ResultError, then screen state should be Error`() =
        runBlocking {
            //Arrange
            whenever(getRecipeListUseCase()).thenReturn(
                ResultType.Error(Failure.Message("No se pudo obtener las recetas"))
            )
            //Act
            viewModel = RecipeListViewModel(getRecipeListUseCase, Dispatchers.Unconfined)
            viewModel.getRecipeList()
            //Assert
            assertEquals(
                RecipeListState.Error::class.java.simpleName,
                viewModel.screenState.value.javaClass.simpleName
            )
        }

    @Test
    fun `when getRecipeList returns ResultSuccess with list empty, then screen state should be Empty`() =
        runBlocking {
            //Arrange
            whenever(getRecipeListUseCase()).thenReturn(
                ResultType.Success(listOf())
            )
            //Act
            viewModel = RecipeListViewModel(getRecipeListUseCase, Dispatchers.Unconfined)
            viewModel.getRecipeList()
            //Assert
            assertEquals(
                RecipeListState.Empty::class.java.simpleName,
                viewModel.screenState.value.javaClass.simpleName
            )
        }


    @Test
    fun `when searching returns ResultSuccess with list empty`() =
        runBlocking {
            //Arrange
            val query = "no coincide"
            whenever(getRecipeListUseCase()).thenReturn(
                ResultType.Success(FakeDataSource.list)
            )
            //Act
            viewModel = RecipeListViewModel(getRecipeListUseCase, Dispatchers.Unconfined)
            viewModel.searchRecipes(query)
            //Assert
            assertEquals(
                0,
                (viewModel.screenState.value as RecipeListState.Success).list.size
            )
        }

    @Test
    fun `when searching returns ResultSuccess with list two elements`() =
        runBlocking {
            //Arrange
            val query = "rocoto"
            whenever(getRecipeListUseCase()).thenReturn(
                ResultType.Success(FakeDataSource.list)
            )
            //Act
            viewModel = RecipeListViewModel(getRecipeListUseCase, Dispatchers.Unconfined)
            viewModel.searchRecipes(query)
            //Assert
            assertEquals(
                2,
                (viewModel.screenState.value as RecipeListState.Success).list.size
            )
        }

    @Test
    fun `when search query hasn't accent mark and returns ResultSuccess with list one element`() =
        runBlocking {
            //Arrange
            val query = "azucar"
            whenever(getRecipeListUseCase()).thenReturn(
                ResultType.Success(FakeDataSource.list)
            )
            //Act
            viewModel = RecipeListViewModel(getRecipeListUseCase, Dispatchers.Unconfined)
            viewModel.searchRecipes(query)
            //Assert
            assertEquals(
                1,
                (viewModel.screenState.value as RecipeListState.Success).list.size
            )
        }

    @Test
    fun `when search query is empty and returns ResultSuccess with all elements`() =
        runBlocking {
            //Arrange
            val query = ""
            whenever(getRecipeListUseCase()).thenReturn(
                ResultType.Success(FakeDataSource.list)
            )
            //Act
            viewModel = RecipeListViewModel(getRecipeListUseCase, Dispatchers.Unconfined)
            viewModel.searchRecipes(query)
            //Assert
            assertEquals(
                4,
                (viewModel.screenState.value as RecipeListState.Success).list.size
            )
        }
}