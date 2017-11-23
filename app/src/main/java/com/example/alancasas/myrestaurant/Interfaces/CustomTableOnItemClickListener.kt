package com.example.alancasas.myrestaurant.Interfaces

import com.example.alancasas.myrestaurant.Models.Table

interface CustomTableOnItemClickListener {
    fun onCustomTableOnItemClickListener(table: Table, position: Int)
}