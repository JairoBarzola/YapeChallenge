package com.jairbarzola.yapechallenge.data

import com.jairbarzola.yapechallenge.data.repository.RecipeApiClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun testApiInstance(baseUrl: String): RecipeApiClient {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeApiClient::class.java)
    }
}