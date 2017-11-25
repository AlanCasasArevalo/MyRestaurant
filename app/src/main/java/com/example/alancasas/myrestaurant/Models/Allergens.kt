package com.example.alancasas.myrestaurant.Models

import com.example.alancasas.myrestaurant.R
import java.io.Serializable

object Allergens : Serializable {


    private val rice = Allergen("Arroz", R.drawable.arroz)
    private val potatoes = Allergen("Patatas",R.drawable.patata)
    private val lettuce = Allergen("Lechuga",R.drawable.lechuga)
    private val milk = Allergen("Leche",R.drawable.leche)
    private val olive = Allergen("Aceituna",R.drawable.aceituna)
    private val gluten = Allergen("Gluten",R.drawable.gluten)

    private var allergens: List<Allergen> = listOf(
            rice, potatoes, lettuce, milk, olive, gluten
    )

    val allergenCount
        get() = allergens.size

    fun getAllAllergens() : List<Allergen> = allergens

}