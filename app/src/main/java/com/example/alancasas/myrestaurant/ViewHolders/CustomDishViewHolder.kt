package com.example.alancasas.myrestaurant.ViewHolders

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.alancasas.myrestaurant.Adapters.MyGridAllergensAdapter
import com.example.alancasas.myrestaurant.Interfaces.CustomDishOnItemClickListener
import com.example.alancasas.myrestaurant.Models.Dish
import com.example.alancasas.myrestaurant.R
import kotlinx.android.synthetic.main.recycler_view_list_dish.view.*

class CustomDishViewHolder (itemView: View, context:Context) : RecyclerView.ViewHolder(itemView) {

    var dishImage = itemView.dish_image
    var dishName = itemView.dish_name
    var dishPrice = itemView.dish_price
    var dishGridAllergens = itemView.allergens_grid_view

    var context = context

    fun binOnDish ( dish: Dish, listener : CustomDishOnItemClickListener){

        dishImage.setImageResource(dish.image)
        dishName.text = dish.name
        dishPrice.text = "${dish.price}"

        // TODO: tenemos que arreglar lo del la lista de los alergenicos. Tienen que llegar un arra de alergenos que traiga el plato

        dishGridAllergens.adapter = MyGridAllergensAdapter(R.layout.grid_dish_allergens,dish.allergens,context)

        itemView.setOnClickListener {
            listener.onCustomDishOnItemClickListener(dish, adapterPosition)
        }
    }
}

































