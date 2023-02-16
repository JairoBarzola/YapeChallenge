package com.jairbarzola.yapechallenge.data.fake

import com.jairbarzola.yapechallenge.domain.entity.Ingredient
import com.jairbarzola.yapechallenge.domain.entity.Location
import com.jairbarzola.yapechallenge.domain.entity.Recipe
import com.jairbarzola.yapechallenge.domain.entity.RecipeList

object FakeDataSource {

    val list = listOf(
        RecipeList(
            id = "1",
            name = "Ensalada de Betarraga",
            time = 40,
            image = "https://comeperuano.b-cdn.net/wp-content/uploads/2023/02/receta-de-ensalada-de-betarraga.jpg",
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

            )
        ),
        RecipeList(
            id = "2",
            name = "Escribano Arequipeño",
            time = 30,
            image = "https://comeperuano.b-cdn.net/wp-content/uploads/2023/01/receta-de-escribano-arequipeno-con-rocoto-y-tomate.jpg",
            ingredients = listOf(
                Ingredient(
                    name = "rocoto sin venas ni pepa",
                    quantity = "1"
                ),
                Ingredient(
                    name = "tomates sin piel ni pepas",
                    quantity = "2"
                ),
                Ingredient(
                    name = "papas canchán sancochadas",
                    quantity = "4"
                ),
                Ingredient(
                    name = "cucharadas de vinagre blanco",
                    quantity = "2"
                ),
                Ingredient(
                    name = "cucharadas de aceite",
                    quantity = "4"
                ),
                Ingredient(
                    name = "cucharada de perejil picados",
                    quantity = "1"
                ),
                Ingredient(
                    name = "cucharada de sal y pimienta",
                    quantity = "1"
                )
            )
        ),
        RecipeList(
            id = "3",
            name = "Causa de atún",
            time = 45,
            image = "https://comeperuano.b-cdn.net/wp-content/uploads/2020/09/receta-causa-de-atun.jpg",
            ingredients = listOf(
                Ingredient(
                    name = "de papa amarilla prensada",
                    quantity = "500 gr"
                ),
                Ingredient(
                    name = "cucharadas de aceite vegetal",
                    quantity = "3"
                ),
                Ingredient(
                    name = "cucharadas de pasta de ají amarillo",
                    quantity = "3"
                ),
                Ingredient(
                    name = "cucharadas de zumo de limón",
                    quantity = "3"
                ),
                Ingredient(name = "sal al gusto"),
                Ingredient(
                    name = "cebolla picada",
                    quantity = "1"
                ),
                Ingredient(
                    name = "diente de ajo picado",
                    quantity = "1"
                ),
                Ingredient(
                    name = "lata de atún",
                    quantity = "1"
                ),
                Ingredient(
                    name = "cucharada de mayonesa casera o mayonesa de fabrica",
                    quantity = "1"
                ),
                Ingredient(name = "pimienta al gusto")

            )
        ),
        RecipeList(
            id = "4",
            name = "Rocoto relleno",
            time = 35,
            image = "https://comeperuano.b-cdn.net/wp-content/uploads/2020/04/receta-rocoto-relleno..jpg",
            ingredients = listOf(
                Ingredient(
                    name = "rocotos",
                    quantity = "8"
                ),
                Ingredient(
                    name = "azúcar"
                ), Ingredient(
                    name = "vinagre"
                ),
                Ingredient(
                    name = "de bistec picado en dados",
                    quantity = "½ kg"
                ),
                Ingredient(
                    name = "tazas de cebolla roja picadas",
                    quantity = "2"
                ),
                Ingredient(
                    name = "cucharada de ajo molido",
                    quantity = "1"
                ),
                Ingredient(
                    name = "cucharada ají panca licuado",
                    quantity = "1"
                ),
                Ingredient(
                    name = "cucharada de orégano picado fresco",
                    quantity = "1"
                ),
                Ingredient(
                    name = "sal"
                ),
                Ingredient(
                    name = "pimienta"
                ),
                Ingredient(
                    name = "comino"
                ),
                Ingredient(
                    name = "cucharadas de tomates picados en dados",
                    quantity = "2"
                ),
                Ingredient(
                    name = "cucharadas de maní picado",
                    quantity = "4"
                ),
                Ingredient(
                    name = "cucharada de pasas",
                    quantity = "1"
                ),
                Ingredient(
                    name = "huevos duros picados ",
                    quantity = "2"
                ),
                Ingredient(
                    name = "aceitunas (opcional)",
                    quantity = "2"
                ),
                Ingredient(
                    name = "queso fresco"
                ),
                Ingredient(
                    name = "leche evaporada"
                ),
                Ingredient(
                    name = "anís"
                ),

                Ingredient(
                    name = "huevos batidos",
                    quantity = "2"
                )
            )
        )
    )

    val detail = Recipe(
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
        location = Location(-12.04687081326295, -77.03536778023721),
        time = 40
    )
}