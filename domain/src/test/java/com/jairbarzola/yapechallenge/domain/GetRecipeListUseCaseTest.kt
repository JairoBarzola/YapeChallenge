package com.jairbarzola.yapechallenge.domain

import com.jairbarzola.yapechallenge.core.common.Failure
import com.jairbarzola.yapechallenge.core.common.Result
import com.jairbarzola.yapechallenge.data.fake.FakeDataSource
import com.jairbarzola.yapechallenge.domain.repository.RecipeRepository
import com.jairbarzola.yapechallenge.domain.usecase.GetRecipeListUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetRecipeListUseCaseTest {

    lateinit var getRecipeListUseCase: GetRecipeListUseCase
    lateinit var repository: RecipeRepository

    @Before
    fun setup() {
        repository = mock()
        getRecipeListUseCase =
            GetRecipeListUseCase(repository)
    }

    @Test
    fun `when ResultType is Success, method should return recipe list`() = runBlocking {

        //Arrange
        whenever(getRecipeListUseCase()).thenReturn(
            Result.Success(FakeDataSource.list)
        )
        //Act
        val result = getRecipeListUseCase()
        //Assert
        Assert.assertEquals((result as Result.Success).value.size, FakeDataSource.list.size)
    }

    @Test
    fun `when ResultType is Error, method should return failure message`() = runBlocking {

        //Arrange
        val error = Failure.Message("No se pudo obtener las recetas")

        whenever(getRecipeListUseCase()).thenReturn(
            Result.Error(error)
        )
        //Act
        val result = getRecipeListUseCase()
        //Assert
        Assert.assertEquals((result as Result.Error).value, error)
    }
}