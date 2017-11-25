package com.example.alancasas.myrestaurant.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.alancasas.myrestaurant.Models.Dish
import com.example.alancasas.myrestaurant.R

class MyDishesTableDetailAdapter(dishes: Array<Dish>, customTableDishesLayout: Int, context: Context) : BaseAdapter () {

    var dishes = dishes
    var customTableDishesLayout = customTableDishesLayout
    var context = context

    override fun getView(position: Int, customView: View?, parent: ViewGroup?): View {
        var customView: View?
        val layoutInflater = LayoutInflater.from(this.context)
        customView = layoutInflater.inflate(this.customTableDishesLayout, null)

        val currentDish = dishes[position]

        val dishName: TextView = customView.findViewById(R.id.dish_name)
        val dishAmount: TextView = customView.findViewById(R.id.dish_amount)

        dishName.text = currentDish.name
        dishAmount.text = "${currentDish.amountDish}"

        return customView
    }

    override fun getItem(position: Int): Any = dishes[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = dishes.size
}






































