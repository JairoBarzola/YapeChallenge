package com.jairbarzola.yapechallenge.data

import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import com.jairbarzola.yapechallenge.core.common.Failure
import com.jairbarzola.yapechallenge.core.common.Result
import com.jairbarzola.yapechallenge.data.fake.FakeDataSource
import com.jairbarzola.yapechallenge.data.repository.RecipeApiClient
import com.jairbarzola.yapechallenge.data.repository.RecipeRepositoryImpl
import com.jairbarzola.yapechallenge.domain.repository.RecipeRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.net.HttpURLConnection

@ExperimentalCoroutinesApi
class RecipeRepositoryImplTest {

    private lateinit var repository: RecipeRepository
    private lateinit var apiClient: RecipeApiClient
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        apiClient = RetrofitHelper.testApiInstance(mockWebServer.url("/").toString())
        repository = RecipeRepositoryImpl(apiClient)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `for no recipes, api must return empty with http code 200`() = runTest {
        val recipes = listOf<com.jairbarzola.yapechallenge.domain.entity.RecipeList>()
        val expectedResponse = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(Gson().toJson(recipes))
        mockWebServer.enqueue(expectedResponse)

        val actualResponse = repository.getRecipesList()

        assertThat((actualResponse as Result.Success).value).isEmpty()

    }

    @Test
    fun `for multiple recipes, api must return all recipes with http code 200`() = runTest {
        val recipes = FakeDataSource.list
        val expectedResponse = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(Gson().toJson(recipes))
        mockWebServer.enqueue(expectedResponse)

        val actualResponse = repository.getRecipesList()

        assertThat((actualResponse as Result.Success).value).hasSize(recipes.size)

    }

    @Test
    fun `for server error, api must return with http code 5xx`() = runTest {
        val expectedResponse = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_INTERNAL_ERROR)
        mockWebServer.enqueue(expectedResponse)

        val actualResponse = repository.getRecipesList()

        assertThat((actualResponse as Result.Error).value).isInstanceOf(
            Failure.Message::class.java)

    }

    @Test
    fun `for recipe id, api must return with http code 200 and user object`() = runTest {
        val mockUser = FakeDataSource.detail
        val expectedResponse = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(Gson().toJson(mockUser))
        mockWebServer.enqueue(expectedResponse)

        val actualResponse = repository.getRecipeDetail("1")

        assertThat((actualResponse as Result.Success).value).isEqualTo(mockUser)
    }


    @Test
    fun `for recipe id not available, api must return with http code 404 and null user object`() =
        runTest {
            val expectedResponse = MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_NOT_FOUND)
            mockWebServer.enqueue(expectedResponse)

            val actualResponse = repository.getRecipeDetail("5")
            assertThat((actualResponse as Result.Error).value).isInstanceOf(
                Failure.Message::class.java)
        }

    @Test
    fun `for incorrect setup recipes list, method must return an Exception`() = runTest {
        val expectedResponse = MockResponse()

        mockWebServer.url("%")
        mockWebServer.enqueue(expectedResponse)

        val actualResponse = repository.getRecipesList()

        assertThat((actualResponse as Result.Error).value).isInstanceOf(
            Failure.Exception::class.java)

    }

    @Test
    fun `for incorrect setup recipe detail, method must return an Exception`() = runTest {
        val expectedResponse = MockResponse()
        mockWebServer.url("%")
        mockWebServer.enqueue(expectedResponse)

        val actualResponse = repository.getRecipeDetail("1")

        assertThat((actualResponse as Result.Error).value).isInstanceOf(
            Failure.Exception::class.java)

    }
}