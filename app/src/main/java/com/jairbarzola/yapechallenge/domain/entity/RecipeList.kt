package com.jairbarzola.yapechallenge.domain.entity

data class RecipeList(
    val id: String,
    val name: String,
    val time: Int,
    val image: String,
    val ingredients: List<Ingredient>
)