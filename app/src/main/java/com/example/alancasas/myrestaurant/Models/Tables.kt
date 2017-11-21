package com.example.alancasas.myrestaurant.Models

import java.io.Serializable


class Tables : Serializable {

    private var tables : List<Table> = listOf(
            Table(1, null, 0.0),
            Table(2, null, 0.0),
            Table(3, null, 0.0),
            Table(4, null, 0.0),
            Table(5, null, 0.0),
            Table(6, null, 0.0),
            Table(7, null, 0.0)
    )

    val count
        get() = tables.size

    operator fun get(position: Int) = tables[position]

    fun tablesListToArray() = tables.toTypedArray()

}