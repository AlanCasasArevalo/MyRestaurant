package com.example.alancasas.myrestaurant.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.alancasas.myrestaurant.Interfaces.CustomTableOnItemClickListener
import com.example.alancasas.myrestaurant.Models.Table
import com.example.alancasas.myrestaurant.ViewHolders.CustomTableViewHolder

class MyTableListAdapter(tables: Array<Table>, customTableLayout: Int, listener: CustomTableOnItemClickListener) : RecyclerView.Adapter<CustomTableViewHolder>()  {

    private var tables = tables
    private var customTableLayout = customTableLayout
    private var tableClickListener = listener
    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomTableViewHolder {
        val customTableView = LayoutInflater.from(parent?.context).inflate(customTableLayout, parent, false)
        if (parent != null){
            context = parent.context
        }
        return context.let { CustomTableViewHolder(customTableView, it) }
    }

    override fun onBindViewHolder(holder: CustomTableViewHolder?, position: Int) {
        holder?.bin(tables[position],tableClickListener)
    }

    override fun getItemCount(): Int = tables.size
}





























