package com.jairbarzola.yapechallenge.networking

import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.TlsVersion
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class BaseApiClient<T>(private val classT: Class<T>) {
    companion object {
        val URL_SERVER: String = "https://demo9019439.mockable.io/"
        const val CONNECTION_TIMEOUT: Long = 180L
        const val READ_TIMEOUT: Long = 180L
        const val WRITE_TIMEOUT: Long = 180L
    }

    open fun getApiClient(): T {
        val okHttpClient = okHttpClient()
        val retrofitBuilder = Retrofit.Builder().apply {
            baseUrl(URL_SERVER)
            client(okHttpClient)
            addConverterFactory(GsonConverterFactory.create())
        }

        val retrofit = retrofitBuilder.build()
        return retrofit.create(classT)
    }

    private fun okHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val requireTls12 = ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
            .tlsVersions(TlsVersion.TLS_1_2)
            .build()

        return OkHttpClient().newBuilder()
            .connectionSpecs(listOf(requireTls12))
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }
}