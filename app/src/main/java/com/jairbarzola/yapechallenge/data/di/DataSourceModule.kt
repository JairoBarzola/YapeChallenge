package com.jairbarzola.yapechallenge.data.di

import android.content.Context
import com.jairbarzola.yapechallenge.core.networking.BaseApiClient
import com.jairbarzola.yapechallenge.data.repository.RecipeApiClient
import com.jairbarzola.yapechallenge.data.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun recipeRepositoryImpl(recipeApiClient: RecipeApiClient): RecipeRepositoryImpl {
        return RecipeRepositoryImpl(recipeApiClient)
    }

    @Singleton
    @Provides
    fun provideRecipeApiClient(@ApplicationContext context: Context): RecipeApiClient =
        BaseApiClient(RecipeApiClient::class.java).getApiClient(context)
}