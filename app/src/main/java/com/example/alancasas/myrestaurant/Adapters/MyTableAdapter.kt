package com.example.alancasas.myrestaurant.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.alancasas.myrestaurant.Interfaces.CustomTableOnItemClickListener
import com.example.alancasas.myrestaurant.Models.Table
import com.example.alancasas.myrestaurant.ViewHolders.CustomTableViewHolder

class MyTableAdapter(tables: Array<Table>, customTableLayout: Int, listener: CustomTableOnItemClickListener) : RecyclerView.Adapter<CustomTableViewHolder>()  {

    var tables = tables
    var customTableLayout = customTableLayout
    var tableClickListener = listener
    lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomTableViewHolder {
        var customTableView = LayoutInflater.from(parent?.context).inflate(customTableLayout, parent, false)
        if (parent != null){
            context = parent.context
        }
        return context?.let { CustomTableViewHolder(customTableView, it) }
    }

    override fun onBindViewHolder(holder: CustomTableViewHolder?, position: Int) {
        holder?.bin(tables[position],tableClickListener)
    }

    override fun getItemCount(): Int {
         return tables.size
    }
}