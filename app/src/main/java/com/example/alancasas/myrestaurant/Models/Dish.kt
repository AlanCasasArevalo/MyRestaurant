package com.example.alancasas.myrestaurant.Models

import java.io.Serializable

data class Dish(val name: String, val description: String, val image: Int, val price: Double, var amountDish: Int, val coockTime: Int, val garnish: List<String>, val allergens: List<Allergen>) : Serializable
