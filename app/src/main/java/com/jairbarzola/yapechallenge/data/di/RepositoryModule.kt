package com.jairbarzola.yapechallenge.data.di

import com.jairbarzola.yapechallenge.data.repository.RecipeRepositoryImpl
import com.jairbarzola.yapechallenge.domain.repository.RecipeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRecipeRepository(impl: RecipeRepositoryImpl): RecipeRepository

}