package com.example.alancasas.myrestaurant.Interfaces

import com.example.alancasas.myrestaurant.Models.Dish

interface CustomDishOnItemClickListener {
    fun onCustomDishOnItemClickListener(dish: Dish, position: Int)
}