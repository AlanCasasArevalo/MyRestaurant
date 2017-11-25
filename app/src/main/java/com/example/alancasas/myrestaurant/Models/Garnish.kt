package com.example.alancasas.myrestaurant.Models

import java.io.Serializable

object Garnish : Serializable {

    private val fries = "Patatas fritas"
    private val backed = "Patatas al horno"
    private val salad = "Ensalada"
    private val rice = "Arroz"

    private val cherryMermelade = "Mermelada de cereza"
    private val chocolatte = "Chocolate derretido"
    private val cream = "Nata montada"
    private val mix = "Mezcla de todos los topings"

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

    fun getAllFirstGarnish(): List<String> = firstGarnish

    fun getAllDessertGarnish() : List<String> = dessertGarnish

}