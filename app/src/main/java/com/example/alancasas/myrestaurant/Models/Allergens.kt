package com.example.alancasas.myrestaurant.Models

import com.example.alancasas.myrestaurant.R
import java.io.Serializable

object Allergens : Serializable {

    private val rice = Allergen( R.drawable.arroz)
    private val potatoes = Allergen(R.drawable.patata)
    private val lettuce = Allergen(R.drawable.lechuga)
    private val milk = Allergen(R.drawable.leche)
    private val olive = Allergen(R.drawable.aceituna)
    private val gluten = Allergen(R.drawable.gluten)

    private var allergens: Array<Allergen> = arrayOf(
            rice, potatoes, lettuce, milk, olive, gluten
    )

    fun getAllergenArray() = allergens

}