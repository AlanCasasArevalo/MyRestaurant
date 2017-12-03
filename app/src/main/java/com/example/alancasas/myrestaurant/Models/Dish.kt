package com.example.alancasas.myrestaurant.Models

import java.io.Serializable

data class Dish(val name: String, val description: String, val image: Int, val price: Double, var amountDish: Int, val coockTime: Int, val garnish: List<String>?, val allergens: Array<Allergen>?) : Serializable, Comparable<Dish> {

    val proxy = "$name $description"

    override fun compareTo(other: Dish): Int {
        return if (name === other.name){
            -1
        }else{
            1
        }
    }

    override fun equals(other: Any?): Boolean {
        return this === other
    }
}

