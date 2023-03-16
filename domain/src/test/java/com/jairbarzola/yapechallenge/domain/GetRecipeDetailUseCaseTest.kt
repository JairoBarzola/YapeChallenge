package com.jairbarzola.yapechallenge.domain

import com.jairbarzola.yapechallenge.core.common.Failure
import com.jairbarzola.yapechallenge.core.common.Result
import com.jairbarzola.yapechallenge.data.fake.FakeDataSource.detail
import com.jairbarzola.yapechallenge.domain.repository.RecipeRepository
import com.jairbarzola.yapechallenge.domain.usecase.GetRecipeDetailUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever


class GetRecipeDetailUseCaseTest {

    lateinit var getRecipeDetailUseCase : GetRecipeDetailUseCase
    lateinit var repository: RecipeRepository

    @Before
    fun setup(){
        repository = mock()
        getRecipeDetailUseCase =
            GetRecipeDetailUseCase(repository)
    }


    @Test
    fun `when ResultType is Success, method should return detail recipe`() = runBlocking {

        //Arrange
        val id = "1"
        whenever(getRecipeDetailUseCase(id)).thenReturn(
            Result.Success(detail)
        )
        //Act
        val result = getRecipeDetailUseCase.invoke(id)
        //Assert
        Assert.assertEquals((result as com.jairbarzola.yapechallenge.core.common.ResultType.Result.Success).value.id,id)
    }

    @Test
    fun `when ResultType is Error, method should return failure message`() = runBlocking {

        //Arrange
        val id = "1"
        val error = Failure.Message("No se pudo obtener la receta")

        whenever(getRecipeDetailUseCase(id)).thenReturn(
            Result.Error(error)
        )
        //Act
        val result = getRecipeDetailUseCase.invoke(id)
        //Assert
        Assert.assertEquals((result as com.jairbarzola.yapechallenge.core.common.ResultType.Result.Error).value,error)
    }

}