package com.example.alancasas.myrestaurant.Models

import java.io.Serializable

object Garnish : Serializable {

    val fries = "Patatas fritas"
    val backed = "Patatas al horno"
    val salad = "Ensalada"
    val rice = "Arroz"

    val cherryMermelade = "Mermelada de cereza"
    val chocolatte = "Chocolate derretido"
    val cream = "Nata montada"
    val mix = "Mezcla de todos los topings"

    private var firstGarnish : List<String> = listOf(
            fries, backed, salad,rice
    )

    private var dessertGarnish : List<String> = listOf(
            cherryMermelade, chocolatte, cream, mix
    )

    val firstGarnishCount
        get() = firstGarnish.size

    val dessertGarnishCount
        get() = dessertGarnish.size

    fun getAllFirstGarnish(): List<String> {
        return firstGarnish
    }

    fun getAllDessertGarnish() : List<String> { return dessertGarnish }

}