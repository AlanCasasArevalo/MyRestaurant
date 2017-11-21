package com.example.alancasas.myrestaurant.Models

import java.io.Serializable

data class Table (val numberTable: Int, val dish: Dish?, var billTable: Double) : Serializable {
    val nameOfTable: String = "Mesa : $numberTable"
    override fun toString() = nameOfTable
}