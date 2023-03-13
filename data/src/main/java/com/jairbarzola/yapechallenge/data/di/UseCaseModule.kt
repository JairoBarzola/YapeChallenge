package com.jairbarzola.yapechallenge.data.di

import com.jairbarzola.yapechallenge.domain.repository.RecipeRepository
import com.jairbarzola.yapechallenge.domain.usecase.GetRecipeDetailUseCase
import com.jairbarzola.yapechallenge.domain.usecase.GetRecipeListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

     @Provides
     fun getRecipeListUseCase(repository: RecipeRepository) =
         GetRecipeListUseCase(repository)

    @Provides
    fun getRecipeDetailUseCase(repository: RecipeRepository) =
        GetRecipeDetailUseCase(repository)

}