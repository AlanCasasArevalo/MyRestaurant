package com.example.alancasas.myrestaurant.Models

import com.example.alancasas.myrestaurant.R
import java.io.Serializable

object Allergens : Serializable {


    val rice = Allergen("Arroz", R.drawable.arroz)
    val potatoes = Allergen("Patatas",R.drawable.patata)
    val lettuce = Allergen("Lechuga",R.drawable.lechuga)
    val milk = Allergen("Leche",R.drawable.leche)
    val olive = Allergen("Aceituna",R.drawable.aceituna)
    val gluten = Allergen("Gluten",R.drawable.gluten)

    private var allergens: List<Allergen> = listOf(
            rice, potatoes, lettuce, milk, olive, gluten
    )

    val allergenCount
        get() = allergens.size

    fun getAllAllergens() : List<Allergen> {
        return allergens
    }

}