package com.example.alancasas.myrestaurant.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.alancasas.myrestaurant.Models.Allergen
import com.example.alancasas.myrestaurant.R

class MyGridAllergensAdapter (customGridLayout: Int, dishAllergens: Array<Allergen>, context: Context ) : BaseAdapter(){

    private var context = context
    private var customGridLayout = customGridLayout
    private var dishAllergens = dishAllergens

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        if (parent != null){
            context = parent.context
        }
        var dishView = convertView
        var currentAllergenDish = dishAllergens[position]
        var layoutInflater = LayoutInflater.from(context)

        dishView = layoutInflater.inflate(customGridLayout, parent,false)



        return dishView
    }

    override fun getItem(position: Int): Any = dishAllergens[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = dishAllergens.size
}











