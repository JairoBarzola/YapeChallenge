package com.jairbarzola.yapechallenge.domain.usecase

import com.jairbarzola.yapechallenge.core.common.Failure
import com.jairbarzola.yapechallenge.core.common.ResultType
import com.jairbarzola.yapechallenge.core.networking.BaseApiClient
import com.jairbarzola.yapechallenge.data.fake.FakeDataSource
import com.jairbarzola.yapechallenge.data.repository.RecipeApiClient
import com.jairbarzola.yapechallenge.data.repository.RecipeRepositoryImpl
import com.jairbarzola.yapechallenge.domain.repository.RecipeRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever


class GetRecipeDetailUseCaseTest {

    lateinit var getRecipeDetailUseCase : GetRecipeDetailUseCase
    lateinit var repository: RecipeRepository

    @Before
    fun setup(){
        repository = mock()
        getRecipeDetailUseCase = GetRecipeDetailUseCase(repository)
    }


    @Test
    fun `when ResultType is Success, method should return detail recipe`() = runBlocking {

        //Arrange
        val id = "1"
        whenever(getRecipeDetailUseCase(id)).thenReturn(
            ResultType.Success(FakeDataSource.detail)
        )
        //Act
        val result = getRecipeDetailUseCase.invoke(id)
        //Assert
        Assert.assertEquals((result as ResultType.Success).value.id,id)
    }

    @Test
    fun `when ResultType is Error, method should return failure message`() = runBlocking {

        //Arrange
        val id = "1"
        val error = Failure.Message("No se pudo obtener la receta")

        whenever(getRecipeDetailUseCase(id)).thenReturn(
            ResultType.Error(error)
        )
        //Act
        val result = getRecipeDetailUseCase.invoke(id)
        //Assert
        Assert.assertEquals((result as ResultType.Error).value,error)
    }

}