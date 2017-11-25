package com.example.alancasas.myrestaurant.Models

import com.example.alancasas.myrestaurant.R
import java.io.Serializable

class Dishes : Serializable {

    var dishes: List<Dish> = listOf(
            Dish("Berenjenas a la miel",
                    "Deliciosas berenjenas rebozadas, fritas en un aceite de oliva virgen extra",
                    R.drawable.berenjenas,
                    8.0,0,10,
                    Garnish.getAllFirstGarnish(),
                    Allergens.getAllAllergens()),

            Dish("Cuscús con verduras y especias",
                    "Delicioso cuscus con verduras de la huerta rehogadas en aceite de oliva virgen extra con las especias mas selectas de la india",
                    R.drawable.cuscus,
                    8.0, 0,
                    10,
                    Garnish.getAllFirstGarnish(),
                    Allergens.getAllAllergens()),

            Dish("Lomo de cerdo al horno",
                    "Cerdo criado en granja, cocinado con todo el mimo y horneado a fuego lento.",
                    R.drawable.lomo,
                    10.0,0,
                    15,
                    Garnish.getAllFirstGarnish(),
                    Allergens.getAllAllergens()),

            Dish("Ternera en salsa teriyaki",
                    "Deliciosa ternera cocinada con verduras y una salsa teriyaki traida desde el mismo Japon",
                    R.drawable.ternera_teriyaki,
                    15.0,0,
                    20,
                    Garnish.getAllFirstGarnish(),
                    Allergens.getAllAllergens()),

            Dish("Tarta de manzana",
                    "Si quieres algo dulce, pero sin remordimientos, tu mejor opción es un trozo de tarta de manzana. Sí, es un dulce, pero estaréis tomando en cada bocado algo de fruta. Si bien no es lo más recomendable, un dulce ocasionalmente es un placer para los sentidos. Por eso te invitamos a que descubras todas las recetas de tarta de manzana que tenemos para ti.",
                    R.drawable.tarta_manzana,
                    8.5,0,
                    5,
                    Garnish.getAllDessertGarnish(),
                    Allergens.getAllAllergens()),

            Dish("Helado de chocolate",
                    "Un delicado postre suculento y caprichoso",
                    R.drawable.helado_chocolate,
                    3.5,0,
                    2,
                    Garnish.getAllDessertGarnish(),
                    Allergens.getAllAllergens())

    )

    val count
        get() = dishes.size

    operator fun get(index: Int) = dishes[index]

    fun dishListToArray() = dishes.toTypedArray()

}