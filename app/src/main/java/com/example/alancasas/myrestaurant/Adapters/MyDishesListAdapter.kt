package com.example.alancasas.myrestaurant.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.alancasas.myrestaurant.Interfaces.CustomDishOnItemClickListener
import com.example.alancasas.myrestaurant.Models.Dishes
import com.example.alancasas.myrestaurant.ViewHolders.CustomDishViewHolder

/**
 * Created by alancasas on 24/11/17.
 */
class MyDishesListAdapter (dishes: Dishes?, customDishLayout: Int, listerner: CustomDishOnItemClickListener) : RecyclerView.Adapter<CustomDishViewHolder>()   {

    private var dishes = dishes
    private var customDishLayout = customDishLayout
    var dishClickListener = listerner
    lateinit var context: Context

    override fun getItemCount(): Int = dishes!!.count

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomDishViewHolder {
        val customDishView = LayoutInflater.from(parent?.context).inflate(customDishLayout, parent,false)
        if(parent != null){
            context = parent.context
        }
        return context.let {
            CustomDishViewHolder(customDishView, it)
        }
    }

    override fun onBindViewHolder(holder: CustomDishViewHolder?, position: Int) {
        holder?.binOnDish(dishes!![position], dishClickListener)
    }
}