package com.jairbarzola.yapechallenge.domain.entity

data class Recipe(
    val id: String,
    val name: String,
    val ingredients: List<Ingredient>,
    val image: String,
    val difficulty: Int,
    val description: String,
    val instructions: List<String>,
    val location: Location,
    val time: Int
)

data class Ingredient(
    val name: String,
    val quantity: String = ""
)

data class Location(
    val latitude: Double,
    val longitude: Double
)
