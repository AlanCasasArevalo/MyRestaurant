package com.example.alancasas.myrestaurant.Models

import java.io.Serializable

data class Table (val numberTable: Int, var dishes: List<Dish>?, var billTable: Double) : Serializable