package com.jairbarzola.yapechallenge.list

import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jairbarzola.yapechallenge.list.helper.detailHelper
import com.jairbarzola.yapechallenge.list.helper.listHelper
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecipeListScreenTest {

    @get: Rule
    val composeTestRule = createComposeRule()


    @Test
    fun whenLoadingState_shouldProgressBeDisplayed() {
        //Arrange
        val progressIndeterminateMatcher = SemanticsMatcher.expectValue(
            SemanticsProperties.ProgressBarRangeInfo, ProgressBarRangeInfo.Indeterminate
        )
        //Act
        composeTestRule.setContent {
            RecipeListScreen(screenState = RecipeListState.Loading,
                navigateToDetail = {},
                onSearchRecipes = {},
                getRecipeList = {})
        }

        //Assert
        composeTestRule.onNode(progressIndeterminateMatcher).assertIsDisplayed()
    }

    @Test
    fun whenSuccessState_shouldRecipeListContentBeDisplayed() {
        //Arrange
        val successState = RecipeListState.Success(
            listHelper
        )
        // Act
        composeTestRule.setContent {
            RecipeListScreen(screenState = successState,
                navigateToDetail = {},
                onSearchRecipes = {},
                getRecipeList = {})
        }

        composeTestRule.onRoot().printToLog("RecipeListScreenTest")
        // Assert

        composeTestRule.onNodeWithContentDescription(detailHelper.name, useUnmergedTree = true)
            .assertIsDisplayed()
    }
}