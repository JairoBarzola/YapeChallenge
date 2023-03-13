package com.jairbarzola.yapechallenge.detail.helper

import com.jairbarzola.yapechallenge.domain.entity.Ingredient
import com.jairbarzola.yapechallenge.domain.entity.Location
import com.jairbarzola.yapechallenge.domain.entity.Recipe

val detailHelper = Recipe(
    id = "1",
    name = "Ensalada de Betarraga",
    ingredients = listOf(
        Ingredient(
            name = "betarragas grandes",
            quantity = "3"
        ),
        Ingredient(
            name = "zanahorias",
            quantity = "2"
        ),
        Ingredient(
            name = "tomates",
            quantity = "2"
        ),
        Ingredient(
            name = "cebolla cortada en juliana",
            quantity = "1"
        ),
        Ingredient(name = "culantro picado finamente"),
        Ingredient(
            name = "huevos cocidos ",
            quantity = "2"
        ),
        Ingredient(name = "sal al gusto"),
        Ingredient(name = "un chorro de aceite de oliva")

    ),
    image = "https://comeperuano.b-cdn.net/wp-content/uploads/2023/02/receta-de-ensalada-de-betarraga.jpg",
    difficulty = 3,
    description = "La ensalada de betarraga es una de las más emblemáticas recetas de la cultura peruana, es de fácil preparación pero muy sabrosa, se compone de la betarraga, un vegetal muy característico de la sierra peruana, principalmente en las regiones de Arequipa y Cajamarca.",
    instructions = listOf(
        "Pelamos y cortamos las betarragas y las zanahorias en cubos de aproximadamente 2 cm de tamaño.",
        "Cocinamos las betarragas y zanahorias en agua con sal hasta que estén suaves. Escurrimos y dejamos enfriar.",
        "Cortamos los tomates en cubos y retiramos las semillas y la pulpa.",
        "Ponemos la cebolla cortada en juliana en un recipiente con agua fría durante 10 minutos para reducir su picor. Escurrimos y secamos con papel de cocina.",
        "En un tazón grande, mezclamos los cubos de betarragas, zanahoria, tomate, cebolla, culantro y huevos duros cortados en rodajas.",
        "Agregamos el aceite de oliva y mezclamos suavemente hasta que todos los ingredientes estén bien combinados.",
        "Agregamos sal al gusto.",
        "Servimos la ensalada en porciones individuales, adornando con un poco más de culantro picado y unas rodajas de huevo duro.",
        "Finalmente, si lo desea, puede agregar un poco de mayonesa para darle un toque cremoso a la ensalada."
    ),
    location = Location(
        -12.04687081326295,
        -77.03536778023721
    ),
    time = 40
)