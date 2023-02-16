package com.jairbarzola.yapechallenge.data.di

import com.jairbarzola.yapechallenge.core.networking.BaseApiClient
import com.jairbarzola.yapechallenge.data.repository.RecipeApiClient
import com.jairbarzola.yapechallenge.data.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun provideRecipeRepositoryImpl(recipeApiClient: RecipeApiClient): RecipeRepositoryImpl {
        return RecipeRepositoryImpl(recipeApiClient)
    }

    @Singleton
    @Provides
    fun provideRecipeApiClient(): RecipeApiClient =
        BaseApiClient(RecipeApiClient::class.java).getApiClient()
}